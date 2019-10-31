import {newReview,saveReview,changeActiveFood} from "../models/userReview.js"
import {updateActiveFood} from "../models/food.js"

const reviewController ={
  sendReview: function(content,rate)
  {
    console.log(content,rate);
    const review=newReview(content,rate);
    saveReview(review);
  },
  changeActiveFood: function(nextFoodId){
    updateActiveFood(nextFoodId)
    changeActiveFood();
  }
}

export default reviewController;