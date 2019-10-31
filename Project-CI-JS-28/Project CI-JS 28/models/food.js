// import user from "./user.js";
import homePage from "../views/homePage.js"

// let activeFood="Bzcx6vrpF8YQwvqwdKIs"
var activeFood = null;


function listenFood(){
    {
        db.collection("food").where("list_users","array-contains",user.authedUser.email).onSnapshot(function(snapshot){
            const conversations =snapshot.docChanges();
            for(let i=0;i<conversations.length;i++){
                const con=conversations[i].doc.data();
                if(conversations[i].type === "added" 
                || (conversations[i].type==="modified" && addedConversations.indexOf(conversations[i].id)<0)){          
                    con.id=conversations[i].doc.id;
                   addedConversations.push(con.id)
                    chatScreen.addCon(con);
                }
            }
        });
    }
}

function saveFood(name,location,price,type,info,imageURL){
    
    db.collection("food")
    .doc()
    .set({
        name:name,
        location:location,
        price:price,
        type:type,
        info:info,
        imageURL:imageURL,
    })
    .then(function(){
       alert("New food has been added!")
    })
    .catch(function(err){
        alert("Failed to add new food ",err);
    })
}


function updateActiveFood(nextFoodId) {
    const oldFood= activeFood;
    activeFood= nextFoodId;
    homePage.updateActiveFood(oldFood);
    // chatScreen.updateActiveCon(oldCon);
    // updateListuser(activeConversation)
}
export {activeFood,saveFood,updateActiveFood};