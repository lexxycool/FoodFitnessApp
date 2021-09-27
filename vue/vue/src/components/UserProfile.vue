<template>
  <div>
      <div class="container">
          <h1 class="brand"><span class="user">User</span> Profile</h1>
          <div class="wrapper">
              <div class="company-info">
                  <h3>Profile Picture</h3>
                
              </div>
            
         
          <div class="contact">
              <h3>Personal Information</h3>
              <form action="">
                  <p>
                      <label for="">Firstname</label>
                      <input type="text" name="firstname">
                  </p>
                  <p>
                      <label for="">Lastname</label>
                      <input type="text" name="lastname">
                  </p>
                   <p>
                      <label for="">Birthhday <span>(mm/dd/yy)</span></label>
                      <input type="text" name="name">
                  </p>
                   <p>
                      <label for="">Height <span>(feet/inches)</span> </label>
                      <input type="text" name="name">
                  </p>
                    <p>
                      <label for="">Weight <span>(lbs)</span> </label>
                      <input type="number" name="phone"> 
                  </p>
                    <p>
                      <label for="">Goal Weight<span>(lbs)</span></label>
                      <input type="number" name="phone">
                  </p>
                   
                  <p class="full">
                      <button>Submit</button>
                  </p>
                  
              </form>
               </div> 

          </div>
           
      </div>

</div>
</template>

<script>
export default {
    // name: 'user-profile',
    // data() {
    //     return {
    //         profile: {
    //                     firstname: '',
    //                     lastname: '',
    //                     age: '',
    //                     height: '',
    //                     currentweight: '',
    //                     goalweight: '',
    //                     birthday: '',
    //                 }
    //         }
    // },
  

  
}
</script>

<style>
    * {
        box-sizing: border-box;
    }

    body {
       
        color: #485e74;
        line-height: 1.6;
        font-family: 'Segoa UI', 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        padding: 1em;


    }

    .contact h3 {
        text-align: center;
        font-size: 1.15em;
        font-weight: bold;
    }

    .container {
        max-width: 1000px;
        margin-left: auto;
        margin-right: auto;
        padding: 1em;
      
    }
  
    

    .container > .brand > .user {
        color:rgba(72, 96, 116, 0.7);
          
    }

    ul {
        list-style: none;
        padding: 0;
    }

    .brand {
        text-align: center;
    }

    .brand span {
        color: #fff;
    }

    .wrapper {
        box-shadow: 0  0 20px 0 rgba(72, 96, 116, 0.7);
  
    }

    .wrapper > * {
        padding: 1em;
    }

    .company-info {
        background: #c9e6ff;
    }

     .company-info h3 {
        background: #c9e6ff;
        font-weight: bold;
        font-size: 15px;
    }
    
    .company-info h3, .company-info ul {
        text-align: center;
        margin: 0 0 1rem 0;
    }

    .contact > form > input {
        width: 20%;
    }

    .contact {
        background: #f9feff;
        
    }

    .contact form {
        display: grid;
        grid-template-columns: 1fr 1fr;
        grid-gap: 20px;
    }

    .contact form label {
        display: block;
        font-size: 14px;
    }

    .contact form p {
        margin: 0;
    }

    .contact form p span {
        font-size: 13px;
    }

    .contact form .full {
        grid-column: 1/3;
    }

    .contact form input {
        width: 90%;
        padding: 0.5em;
        border: 1px solid #c9e6ff;
    }

    .contact form button {
        background: #c9e6ff;
        border: 0;
        text-transform: uppercase;
        width: 95%;
        padding: 0.5em;
        font-size: 15px;
        font-weight: 700;
        color: #485e74;

    }

    .contact form button:hover, .contactform button:focus {
        background: #92bde7;
        color: #fff;
        outline: 0;
        transition: background-color 2s ease-out;
    }

    @media(min-width: 700px) {
        .wrapper {
            display: grid;
            grid-template-columns: 1fr 2fr;
        }

        .wrapper > * {
            padding: 2em;
        }

        .company-info h3, .company-info ul, .brand {
            text-align: left;

        }

       

    }
    

     

</style>