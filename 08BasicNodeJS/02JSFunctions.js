this.tax = 10;

var x = function(a,b){
    return a + b + this.tax;
}
console.log(x(10,20));

//---------------A new sytax to write function - Arrow function
y = (a,b) => {
    return a + b + this.tax;
}
console.log(y(10,20));




// var myReuse = require("./reuse");

// var arr = ["apple","banana","cherry"];
// var arr2 = ["miami","santa clara","las vegas"];

// myReuse.printf(arr);
// myReuse.removeItem(arr, 0);
// myReuse.getCount(arr);

// myReuse.printf(arr);
// myReuse.printf(arr2);



/////----Basics of functions - named function

// var arr = ["apple","banana","cherry"];
// var arr2 = ["miami","santa clara","las vegas"];

// var printf = function(arrObject){
//     for (let i = 0; i < arrObject.length; i++) {
//         const element = arrObject[i];
//         console.log(element);
//     }
// }

// printf(arr);
// printf(arr2);