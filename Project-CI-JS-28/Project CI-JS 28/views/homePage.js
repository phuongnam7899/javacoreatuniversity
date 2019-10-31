import reviewController from "../controllers/reviewController.js"
import addFoodController from "../controllers/addFoodController.js"
import user from "../models/user.js"
import { activeFood } from "../models/food.js"
const ui =
    `
<div class="header sticky-top">
        <div class="web-name-banner">WEBSITE NAME</div>
        <div class="main-nav">
            <div id="food" class="nav-item" >Food</div>
            <div id="drink" class="nav-item ">Cafe/Drink</div>
            <div class="nav-item ">Checkin</div>
            <div class="search-container">
                <form id="">
                    <input type="text" placeholder="Looking for something...?">
                    <button type="submit">Search</button>
                </form>
            </div>
        </div>
    </div>

    <div id="head" class="bm">
        <div id="left" class="bm">Quảng cáo</div>
        <div id="content" class="bm">
        <div id="js-showFoodContainer" class="d-flex">
        
        </div>
        </div>
    </div>

<div id="js-addReviewContainer"></div>
<div id="js-addFoodContainer"></div>

<div id="js-popUpInfo">
<div id="js-reviewContainer" class="userReview vertical-scroll"></div>
</div>

`

const btnShowHTML = `
<button id="js-openReviewFormBtn">Write a review</button>
`

const btnAddNewFoodHTML=`<button id="js-openAddNewFoodFormBtn">Add New Food (For admin only)</button>`

const formWriteReviewHTML =
    `<form id="js-writeReviewForm">
                  <div id="ratingStar">
                  <label style="">Rating:</label>
                  <div class="stars">
  <input class="star star-1" id="star-1" type="radio" name="star" value="5" ;"/>
  <label class="star star-1" for="star-1"></label>
  <input class="star star-2" id="star-2" type="radio" name="star" value="4" ;"/>
  <label class="star star-2" for="star-2"></label>
  <input class="star star-3" id="star-3" type="radio" name="star" value="3" ;"/>
  <label class="star star-3" for="star-3"></label>
  <input class="star star-4" id="star-4" type="radio" name="star" value="2";"/>
  <label class="star star-4" for="star-4"></label>
  <input class="star star-5" id="star-5" type="radio" name="star" value="1" ;"/>
  <label class="star star-5" for="star-5"></label>
</div>
                  </div>
                  <label style="display:block">Tell us your opinion:</label>
                  <textarea id="reviewContent" style="display:block " name="reviewInput" rows="10" cols="50" placeholder="Type here ..."></textarea>
                  <button type="submit">Send your review!</button>
                  <button id="js-closeFormBtn" type="button" class="btn cancel">Close</button>
              </form>            
        `

        //test

       

function onLoad() {
    addNewReview();
    addNewFood();
    // db.collection("food").where("name","==","MIẾN TRỘN PHỦ DOÃN").get().then((food)=>{
    //     food.forEach((f) => {
    //         console.log(f.data())
    //     })
    // })
    
    foodFilter();
    drinkFilter()
    //show all food
    db.collection("food")
    .onSnapshot(function(snapshot){
        const food=snapshot.docChanges();
        for(let i=0;i<food.length;i++){
            if(food[i].type==="added"){
                // console.log(food[i].doc.id,food[i].doc.data())
              homePage.showFood(food[i].doc.id,food[i].doc.data())
            
            }
        }
    });
// const showFoodContainer=document.getElementById("js-showFoodContainer")
//     showFoodContainer.addEventListener("click", function (event) {
//         console.log(event.target.id);
//        addFoodController.changeActiveFood(event.target.id);
//     })




 //show user review
    db.collection("review").where("foodName","==",activeFood)
    .orderBy("created_at")
    .onSnapshot(function(snapshot){
        const review =snapshot.docChanges();
        for(let i=0;i<review.length;i++){ 
            if(review[i].type==="added"){
                homePage.showReview(review[i].doc.data())  
            }
        }
    });
};
// function openInfo()
// {
//     const showFoodContainer=document.getElementById("js-showFoodContainer")
//    showFoodContainer.addEventListener("click",function(event){
//         showFoodContainer.innerHTML="";
//         db.collection("food").where("imageURL","==",`${event.target.id}`)
//         .onSnapshot(function(snapshot){
//             const food=snapshot.docChanges();
//             for(let i=0;i<food.length;i++){
//                 if(food[i].type==="added"){
//                   homePage.showFood(food[i].doc.id,food[i].doc.data())
//                 }
//             }
//         });
//     })
// }
function getfoodID(){
    console.log("abc")
    const foodActive=document.getElementsByClassName("item");
    for(let i=0;i<foodActive.length;i++){
        // console.log(foodActive[i]);
        foodActive[i].addEventListener("click",function(){
            console.log(this.id)
        })
    }

}
//filter
function foodFilter()
{
    const showFoodContainer=document.getElementById("js-showFoodContainer")
   
    const foodBtn=document.getElementById("food");
    foodBtn.addEventListener("click",function(){
        showFoodContainer.innerHTML="";
        db.collection("food").where("type","==","food")
        .onSnapshot(function(snapshot){
            const food=snapshot.docChanges();
            for(let i=0;i<food.length;i++){
                if(food[i].type==="added"){
                  homePage.showFood(food[i].doc.data())
                }
            }
        });
    })
}

function drinkFilter(){
    {
        const showFoodContainer=document.getElementById("js-showFoodContainer")
       
        const drinkBtn=document.getElementById("drink");
        drinkBtn.addEventListener("click",function(){
            showFoodContainer.innerHTML="";
            db.collection("food").where("type","==","drink")
            .onSnapshot(function(snapshot){
                const food=snapshot.docChanges();
                for(let i=0;i<food.length;i++){
                    if(food[i].type==="added"){
                      homePage.showFood(food[i].doc.data())
                    
                    }
                }
            });
        })
    }
}



function addNewReview() {
    const addReviewContainer = document.getElementById("js-addReviewContainer")
    addReviewContainer.innerHTML = btnShowHTML;
    const openReviewFormBtn = document.getElementById("js-openReviewFormBtn")
    openReviewFormBtn.addEventListener("click", function () {
        addReviewContainer.innerHTML = formWriteReviewHTML;
        openReviewForm();

    })
}


//submit
function openReviewForm() {
    const addReviewContainer = document.getElementById("js-addReviewContainer")
    addReviewContainer.innerHTML = formWriteReviewHTML;
    const formWriteReview = document.getElementById("js-writeReviewForm");
    formWriteReview.addEventListener("submit", function (event) {
        event.preventDefault();
        let rate=postToController();  //value stars
         reviewController.sendReview(formWriteReview.reviewContent.value,rate)
         closeForm();
    })
    const closeFormBtn = document.getElementById("js-closeFormBtn");
    closeFormBtn.addEventListener("click", function () {
        closeForm();
    })
}

function closeForm() {
    addNewReview();
}
//star value
function postToController() {

    for (let i = 0; i < document.getElementsByName('star').length; i++) {
        if (document.getElementsByName('star')[i].checked == true) {
            var ratingValue = document.getElementsByName('star')[i].value;
            break;
        }
    }
    return ratingValue;

}
//for Admin
const formAddNewFoodHTML = `
<form id= "js-formAddFood">
        <div class="">
            <label>Tên món ăn:</label>
            <input id= "foodName" type= "text"/>
        </div>
        <div class="">
            <label>Địa chỉ quán:</label>
            <input id="location" type="text"  />
        </div>
        <div class="">
            <label>Price:</label>
            <input id="price" type="text"></input>
        </div>
        <div class="">
            <label>Type(food/drink):</label>
            <input id="type" type="text"></input>
        </div>
        <div class="">
            <label>Mô tả/ giới thiệu:</label>
            <textarea id="newFoodInfo" style="display:block " name="reviewInput" rows="10" cols="50" placeholder="Type here ..."></textarea>
        </div>
        <div class="">
            <label>Image URL:</label>
            <input id="imageURL" type="text"></input>
        </div>
        <div class="">
            <button type= "submit"> Confirm </button>
        </div>
        <button id="js-closeFormAddBtn" type="button" class="btn cancel">Close</button>
    </form>
`
//for Admin
function addNewFood(){
    const addFoodContainer = document.getElementById("js-addFoodContainer")
    addFoodContainer.innerHTML = btnAddNewFoodHTML;
    const openAddNewFoodFormBtn = document.getElementById("js-openAddNewFoodFormBtn")
    openAddNewFoodFormBtn.addEventListener("click", function () {
    addFoodContainer.innerHTML = formAddNewFoodHTML;
      openAddFoodForm();
     
    })
    
}
//submit
//for admin
function openAddFoodForm(){
    const addFoodContainer = document.getElementById("js-addFoodContainer")
    addFoodContainer.innerHTML=formAddNewFoodHTML;
    const formAddFood=document.getElementById("js-formAddFood");
    formAddFood.addEventListener("submit",function(event){
        event.preventDefault();
       
        addFoodController.addNewFood(formAddFood.foodName.value,formAddFood.location.value,formAddFood.price.value,formAddFood.type.value,formAddFood.newFoodInfo.value,formAddFood.imageURL.value)
        clearInput(formAddFood.foodName)
        clearInput(formAddFood.location)
        clearInput(formAddFood.price)
        clearInput(formAddFood.type)
        clearInput(formAddFood.newFoodInfo)
        clearInput(formAddFood.imageURL)
    })
    const closeFormAdd=document.getElementById("js-closeFormAddBtn");
    closeFormAdd.addEventListener("click",function(){
        closeAddNewFoodForm()
    })
}

//showReview
function showReview(review){
    const owner= user.authedUser.email;
    const userReview=`
    <div class="vertical-10"></div>
    <small>${owner}</small>
    <div class="vertical-20"></div>
    <div class="flex-container"> 
    <br/> 
    <span class="rating-static rating-${review.rate}"></span>
    <span class="show-user-review">${review.content}</span>
</div>
    `
    const reviewContainer=document.getElementById("js-reviewContainer")
    reviewContainer.insertAdjacentHTML("afterbegin",userReview);

}
// ${foodID === activeFood ? "active" : null}

function showFood(foodID,foodData){
    
    const eachFood=`
<div id="${foodID}" class="item ">
     <div class="pic1 grow-2">
     <img id="" class="hw ""
             src="${foodData.imageURL}">             
        </div>
    <div class="loti1 grow-3">
             <div id="nameFood" class="">${foodData.name}</div>
              <div id="address" class="">${foodData.location}</div>
     </div>
</div>   `
const showFoodContainer=document.getElementById("js-showFoodContainer")
showFoodContainer.insertAdjacentHTML("afterbegin",eachFood);
getfoodID();
}

 
//for admin
function closeAddNewFoodForm(){
    addNewFood();
}

function updateActiveFood(oldFoodId) {
    if (oldFoodId !== null) {
        const currentActiveFood = document.getElementById(oldFoodId);
        currentActiveFood.classList.remove("active");
    }
    const nextActiveFood = document.getElementById(activeFood)
    nextActiveFood.classList.add("active");
}
function clearReviews() {
    const reviewContainer=document.getElementById("js-reviewContainer")
    reviewContainer.innerHTML = "";
}

function clearInput(tag){
    tag.value=""

}
const homePage = {
    ui: ui,
    onLoad: onLoad,
    addNewReview: addNewReview,
    openReviewForm: openReviewForm,
    showReview:showReview,
    showFood:showFood,
    updateActiveFood:updateActiveFood,
    clearReviews:clearReviews,
    
}

export default homePage;


