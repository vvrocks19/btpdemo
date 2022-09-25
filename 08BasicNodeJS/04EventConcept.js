//Simple Event Example

var events = require('events');

var anubhav = new events.EventEmitter();

anubhav.on('speak', () => {
    console.log("how are your folks!");
});

anubhav.emit('speak');

//How to use events in Real-life

var utils = require('util');

var Person = function(name){
    this.name = name;
};

utils.inherits(Person, events.EventEmitter);

var anubhav = new Person("Anubhav");
var ananya = new Person("Ananya");

var people = [anubhav, ananya];

people.forEach(element => {
    element.on('talk', (msg) => {
        console.log(element.name + " says " + msg);
    });
});

anubhav.emit('talk', 'Hey dudes!');
ananya.emit('talk', 'Watsup Gals!!');
