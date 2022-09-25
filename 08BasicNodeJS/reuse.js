module.exports = {

    printf: function(arrObject){
        for (let i = 0; i < arrObject.length; i++) {
            const element = arrObject[i];
            console.log(element);
        }
    },

    getCount: function(arr){
        console.log(arr.length);
    },

    removeItem(arr, index){
        return arr.splice(index, 1);
    }


}