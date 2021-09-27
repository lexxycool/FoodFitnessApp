<template>
  <div>
    <div class="container">

        <h2 class='breakfast'>Add Food to Breakfast</h2>
        <hr>

        <p class="searchbar">
        
            Search out food database by name:
             <input type="search" class="search"> <span><button class="searchbutton">Search</button></span>
             <span class="matchfoods">Matching Foods:</span>
        </p>
        <div class="foodscroll">
            <div class="matchscroll">
      
            </div>

             <div class="scroll">
                <h2>Pear</h2>
                <h4>How much</h4>
                <input type="text" />
                servings of
                <select name="" id="">

                </select>

                <h3>To which Meal?</h3>
                 <select name="" id="breakfast">

                </select>

                <button class="add_diary">Add Food to Diary</button>

            </div> 
            
        </div>
       
        
       
    </div>

  </div>
 
</template>

<script>
export default {

}
</script>

<style scoped>
    * {
        box-sizing: border-box;
    }

    body {
        color: #485e74;
        line-height: 1.6;
        font-family: 'Segoa UI', 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        padding: 1em;
    }

    .container {
        display: grid;
        grid-template-columns: 1fr 1fr;
       
       
    }

    .container hr {
        grid-column: 1/3;
        overflow: visible;
        border: 1px thin gray;
        opacity: 0.5;
        width: 100%;
     
    }

    .breakfast {
        grid-column: 1/3;
        color: rgb(20, 150, 236);
    }

    .searchbar {
        grid-column: 1/3;
        color: rgb(20, 150, 236);
        font-weight: 700;
        font-size: 16px;
    }

    .searchbar > .matchfoods {
        margin-top: 20px;
    }

    .search {
        font-size: 15px;
        margin-bottom: 20px;
    }

   
     .searchbutton {
        font-size: 16px;
        font-weight: 600;
        color: green;
       
    }

    .searchbutton:hover {
        font-size: 16px;
        border: none;
        font-weight: 600;
        background-color: green;
        color:  #fff;
        
    }

    .foodscroll {
        display: grid;
        position: relative;
        grid-column: 1/3;   
        padding: 5px;
        margin-top: 5px;
        width: 100%;
        height: 80vh;
        margin-bottom: 20px;
       
    }

      .matchscroll {
        grid-column: 1/3;   
        border: 1px solid green;
        padding: 5px;
        margin-top: 20px;
        width: 100%;
        height: 40vh;
        margin-bottom: 20px;
        text-align: center;
        overflow: scroll;
        
    }

    .scroll {
        grid-column: 1/3;   
        border: 1px solid green;
        padding: 5px;
        margin-top: 5px;
        width: 100%;
        height: 40vh;
        margin-bottom: 20px;
        text-align: center;
        background-color: whitesmoke;        
        
    }
    
    .scroll h2, h3 {
        font-weight: 700;
        color: rgb(20, 150, 236);     
    }

    .scroll input {
        width: 10%;
        border: 1px solid;
        margin: 0px 10px 0px 10px;
    }

    .scroll > #breakfast {
        width: 50%;
        margin: 0px 10px 0px 10px;
    }

      .scroll select {
        width: 40%;
        margin-left: 10px;
    }

    .add_diary {
        margin-top: 15px;
        padding: 7px 7px;
        color:#fff;
        background: green;
        border: none;
        border-radius: 5px;
        font-size: 13px;
        font-weight: 600;
        
    }

      .add_diary:hover {
        margin-top: 15px;
        padding: 7px 7px;
        background: green;
        border: none;
        border-radius: 5px;
        font-size: 13px;
        font-weight: 600;
        color: #000;
        
    }

    @media(min-width: 700px) {
        .searchbar {
            display: grid;
            grid-column: 1/3;
            color: rgb(20, 150, 236);
            font-weight: 700;
            font-size: 20px;
        }

        .searchbar > input {
            display: grid;
            grid-column: 1fr 1fr;
            width: 50%;
            color: rgb(20, 150, 236);
            font-weight: 700;
            margin-bottom: 0px;
            
        }

        .foodscroll {
            display: flex;
            padding: 5px;
            margin-top: 5px;
            width: 85%;
            height: 40vh;
           
        }

        .scroll {
          overflow-y: scroll;
          margin: 20px;
          
        }

        .scroll input {
            width: 10%;
            margin: 0px 10px 0px 0px;
            border: 1px solid black;

        }

        .scroll select {
            margin-left: 10px;
         }

        .scroll h3 {
            font-weight: 700;
            padding: 10px;
        }


        .foodscroll :nth-child(2) {
           overflow-y: hidden;
           border: none;
        }

       .container hr {
         width: 100%;
         padding-right: 20px;
     
        }


    }

    @media(max-width: 370px) {
          .scroll {
        grid-column: 1/3;   
        border: 1px solid green;
        padding: 5px;
        margin-top: 5px;
        width: 100%;
        height: 50vh;
        margin-bottom: 20px;
        text-align: center;
        
        
    }
    }
</style>