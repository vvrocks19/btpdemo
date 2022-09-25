// console.log("Hello Node JS by AnubhavTrainings.com");

// var x = 10; //This will create a variable x of type number
// console.log(x);
// console.log(typeof(x));

// var y = "10";
// console.log("Y is of type: " + typeof(parseInt(y)));

// var z = false;
// console.log("Z is of type " + typeof(z));

//Array is a collection of values, which is equal to itab
// () - parenthesis
// {} - braces
// [] - bracket

///////////Working with ARRAYS ---**
// var aFruits = ["Apple", "Banana", "Cherry"];
// console.log(aFruits);
// //Counting 
// console.log("My array has " + aFruits.length + " items");
// //The first item is 
// console.log("First Item :  " + aFruits[0]);
// //Last Item of Array is
// console.log("Last Item :  " + aFruits[aFruits.length - 1]);
// //Append an item at End
// console.log("After adding new item " + aFruits.push("PineApple"));
// console.log("My array is now ---> " + aFruits);
// //Insert in the middle
// console.log(aFruits.splice(1,0,"Mango"));
// console.log("After insert at Index 1 ---> " + aFruits);
// //Remove from middle
// console.log(aFruits.splice(2,1));
// console.log("After Remove at Index 2 ---> " + aFruits);
// //Loop over an array
// for (let i = 0; i < aFruits.length; i++) {
//     const element = aFruits[i];
//     console.log("Item At Position " + i + " is ---> ", element);
// }


////////Working with Objects - Objects are like structures in ABAP
///////They contain multiple fields of different data types
// var oEmployee = { 
//     "empId": 1000001,
//     "empName": "Anubhav Oberoi",
//     "salary": 5000,
//     "currency": "USD"
// };

// console.log("A new Object --> ", oEmployee);
// console.log("The Emp name property is ", oEmployee.empName);
// oEmployee.salary = 20000;
// console.log("The new salary for Anubhav is ", oEmployee.salary);
// for (const key in oEmployee) {
//     console.log(oEmployee[key]);
// }


var oComplexJSON = {
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
};

var strJson = JSON.stringify(oComplexJSON);
console.log(strJson);
console.log(JSON.parse(strJson));
