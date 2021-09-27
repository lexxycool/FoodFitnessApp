<template>
  <div class="signup">
       <h2>Create your free techFitness account</h2>

        <form @submit.prevent='registerUser'>
            <div class="register">
           
                <input type="text" placeholder="Email Address" name="text" class="info" v-model="user.username">
                <input type="email" placeholder="Password" name="email" class="info" v-model="user.password">
                <input type="email" placeholder="Confirm Password" name="set_email" class="info" v-model="user.confirmPassword">
              
                
            </div>

        

            <button class="submit">Create Account</button>
         </form>
        
         
    </div>

</template>

<script>
import authService from '../services/AuthService';
export default {
    name: 'new-account',
    data() {
        return {
            user: {
              username: '',
              password: '',
              confirmPassword: '',  
            },
            
        }
    },
    registrationError: false,
    registrationErrorMsg: "Please sign in with the correct username or password", 
    methods: {
        registerUser() {
            if(this.user.password != this.user.username) {
                this.registrationErrors = true;
                alert(this.registrationErrorMsg);

            }else {
                authService
                .addUser()
                .then((response) => {
                    if(response.status == 201) {
                        this.router.push( {name: 'login'} );
                    }
                })
                .catch((error) => {
                    const response = error.response;
                    this.registrationError = true;
                    if(response.status == 401) {
                        this.registrationError = "Please try Again";
                    }
                })
            }
        },
        clear() {
            this.registrationError = false;
        }
    },
}
</script>

<style>
    .signup {
       text-align: center;
       width: 100%;
       height: auto;
    }

    .register {
        max-width: 500px;
        height: 17rem;
        margin: 0 auto;
        padding: 30px;
        margin-top: 20px;
        border: 1px solid #eee;
        border-radius: 10px;
        background: #fefefe;
        
       
    }

    .info {
        display: block;
        width: 100%;
        padding: 10px 15px;
        height: 40px;
        font-size: 15px;
        margin: 10px;
        margin-bottom: 30px;
        border-radius: 5px;
        border: 1px solid #ccc;
        box-sizing: border-box;
    }

    .submit {
        width: 330px;
        margin: 25px 0px;
        opacity: 0.7;
        font-size: 18px;
        padding: 10px 15px;
        font-weight: bold;
        color: #ffff;
        background-color: rgba(20,20,236);
        border: 1px solid;
        border-radius: 5px;      

    }

    ::-webkit-input-placeholder {
        opacity: 0.5;
    }

     @media(min-width: 700px) {
        .submit {
         width: 500px;
        margin: 25px;
        opacity: 0.7;
        font-size: 18px;
        padding: 10px 15px;
        font-weight: bold;
        color: #ffff;
        background-color: rgba(20,20,236);
        border: 1px solid;
        border-radius: 3px; 
        }

        
     } 
    
    

 

 

</style>