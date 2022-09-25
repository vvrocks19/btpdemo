//Webserver dependency to serve microservice
const express = require('express');
//HANA DB Driver to submit calls to HANA
const hdb = require('hdb');
//XS Enviornment to read VCAP_SERVICES to connect to DB
const xsenv = require('@sap/xsenv');
//XS Security dependency to read JWT Token
const { JWTStrategy } = require('@sap/xssec');
//JWT Token needs to be passed in webserver for authentication
const passport = require('passport');

//Read the VCAP_SERVICES to read connection details of HANA HDI Container
const xsenvObj = xsenv.getServices({ hana : { tag : "database" }});
const xsenvObjXSUAA = xsenv.getServices({ uaa : { tag: "xsuaa" }});
const port = process.env.port || 8080;
const app = express();

passport.use(new JWTStrategy(xsenvObjXSUAA.uaa));
app.use(passport.initialize());
app.use(passport.authenticate("JWT", {session: false}));

const hdiConfig = {
    host: xsenvObj.hana.host,
    port: xsenvObj.hana.port,
    user : xsenvObj.hana.hdi_user,
    password: xsenvObj.hana.hdi_password,
    useTLS: true
};
console.log(hdiConfig);

const client = hdb.createClient(hdiConfig);

client.on("error", (err) => {
    console.error("Connection to HANA DB failed because of ", err);
});

app.get("/Vendors", checkRole, getVendorData);
app.get("/Vendors/:id", checkRole, getVendorById);

function checkRole(req, res, next){
    if(req.authInfo.checkLocalScope("AnubhavDisplay")){
        return next();
    }else{
        res.status(403).end("Forbidden");
    }
}

function getVendorData(req,res){
    console.log(xsenvObj.hana);
    client.exec(
        'select * from "' + xsenvObj.hana.schema + '"."VENDOR"',
        function(err, rows){
            client.end();
            if(err){
                console.error("Connect Error ", err);
                res.status(500).end("HANA Call gave error");
            }
            console.log(" Data was : ", rows);
            res.send(rows);
        }

    )
}


function getVendorById(req,res){
    client.exec(
        'select * from "' + xsenvObj.hana.schema + '"."VENDOR" where id = '+ req.params.id,
        function(err, rows){
            client.end();
            if(err){
                console.error("Connect Error ", err);
                res.status(500).end("HANA Call gave error");
            }
            console.log(" Data was : ", rows);
            res.send(rows);
        }

    )
}

app.listen(port);