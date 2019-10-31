import user from "./user.js"
import homePage from "../views/homePage.js"
import {activeFood} from "./food.js"


let unsubscribe = null;

function subscribe(){
   return db.collection("review").where("foodName","==",activeFood)
    .orderBy("created_at")
    .onSnapshot(function(snapshot){
        const review =snapshot.docChanges();
        for(let i=0;i<review.length;i++){ 
            if(review[i].type==="added"){
                homePage.showReview(review[i].doc.data())  
            }
        }
    });
}

function newReview(content,rate) {
    return {
        content: content,
        user: user.authedUser.email,
        rate: rate,
        foodName: activeFood,
    };
}

function saveReview(review)
{
    console.log(review);
  db.collection("review")
  .doc()
  .set({
      ...review,  //merge message vào collection mesages dưới key created_at
      created_at: firebase.firestore.FieldValue.serverTimestamp()
  })
  
  .then(function(){
      alert("Your review has been sent!")
      console.log(user.authedUser.email)
  })
  .catch(function(err){
      alert("Failed to send review: ",err);
  })

}

function changeActiveFood(){   
    if (unsubscribe !== null){
        unsubscribe()
    }
    homePage.clearReviews();
    unsubscribe =subscribe();
   }

export {newReview,saveReview,changeActiveFood}