<template>
  <div class="home">
    <div id="description"><h1>Start your wellness journey with us</h1>
    <h4>Achieve your health goals. Track your food intake, connect with friends, and plan your meals.</h4></div>
    
    <div id="buttons"><button id="registerbutton">Join Today</button>
        <p>Already have an account? <button id="loginbutton">Login</button></p></div>

     <!-- <div id="bottomofpage" align='center'>
        <h2>Add some text here.</h2>
        <p>more text here.</p>
    </div>  -->

    <h1>Home</h1>
   
    <p>You must be authenticated to see this</p>

  </div>
</template>

<script>
export default {
  name: "home"
};
</script>

<style scoped>
#registerbutton {
  width: 22%;
  background-color:rgb(20, 20, 236);
  font-size: 20px;
  font-family:Verdana, sans-serif;
  padding: 12px 28px;
  transition-duration: 0.4s;
  color: white;
  border: white;
  border-radius: 5px;
}

#loginbutton {
color: blue;
background-color: transparent;
border: white;
padding: 0px;
font-family:Verdana, sans-serif;
}

.p{
  font-family: Verdana, sans-serif;
}

h1{
  font-size: 60px;
}

h4 {
  inline-size: 430px;
  overflow-wrap: break-word;
}

/*  #bottomofpage{
  position:absolute;
  bottom:0px;
  right:40%;
}  */

#description{
  padding: 40px 80px;
  inline-size: 500px;
  overflow-wrap: break-word;
}

#buttons{
  padding: 0px 80px;
}

.home{
  background: url(../img/img1.jpg) no-repeat center center fixed;
  background-size: cover;
  height: 100%;
  overflow: hidden;
}

</style>