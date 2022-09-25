var express = require('express');
var app = express();

app.listen(3301);

//Implement first microservice at end point blank /
app.get("/", (req, res) => {
    res.send("Welcome to AnubhavTrainings.com");
});

app.get("/vendors", (req,res) => {
    res.json({
        "empTable": [
            { 
                "empId": 1000001,
                "empName": "Anubhav Oberoi",
                "salary": 5000,
                "currency": "USD"
            },
            { 
                "empId": 1000002,
                "empName": "Lavanya Shenoy",
                "salary": 25000,
                "currency": "USD"
            },
            { 
                "empId": 1000003,
                "empName": "Ananya Biswas",
                "salary": 21000,
                "currency": "EUR"
            }
        ],
        "cities": [
            {
                "cityName": "Jaipur",
                "state": "Rajasthan"
            },
            {
                "cityName": "Bangalore",
                "state": "Karnataka"
            },
            {
                "cityName": "Detroit",
                "state": "USA"
            },
            {
                "cityName": "Mumbai",
                "state": "Maharashtra"
            }
        ],
        "gender": {
                  "M": "Male",
                  "F": "Female"
        }
    });
});

console.log("Your Microservice is running @ http://localhost:3001");