import {saveFood,activeFood,updateActiveFood} from "../models/food.js"
import {changeActiveFood} from "../models/userReview.js"

// import {updateActiveFood} from "../models/food.js"


const addFoodController = {
    addNewFood : function(name,location,price,type,info,imageURL) {
        saveFood(name,location,price,type,info,imageURL)
    },
    changeActiveFood: function(nextFoodId){
        updateActiveFood(nextFoodId);
        changeActiveFood();
    }
    
}

export default addFoodController;