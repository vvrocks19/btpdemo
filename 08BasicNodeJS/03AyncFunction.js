
let util = require('util');
let callMyFunction = util.promisify((ms, f) => setTimeout(f, ms));

console.log("Before Calling my Module ----->");
callMyFunction(3000).then(() => {
    console.log("I am the wait function");
});
console.log("After Calling my Module ----->");

////An example of using ES6 syntax to make JS run synchronously
// const timerFunction = ms => new Promise(resolve => setTimeout(resolve, ms));

// const callMyFunction = () => {
//     return timerFunction(5000).then(()=>{
//         console.log("I am the wait function");
//     });
// }

// const myFunction = async () => {
//     console.log("Before Calling my Module ----->");
//     await callMyFunction();
//     console.log("After Calling my Module ----->");
// }

///--JS Asynchronous behavior
// const myFunction = () => {
//     console.log("Before Calling my Module ----->");
//     //I am not gonna wait here for 5
//     setTimeout(function(){
//         console.log("After Calling my Module ----->");
//     } ,5000);
    
// }

//myFunction();