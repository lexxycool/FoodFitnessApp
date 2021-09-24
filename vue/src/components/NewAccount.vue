<template>
  <div class="signup">
       <h2>Create your free techFitness account</h2>

        <form @submit.prevent='registerUser'>
            <div class="register">
           
                <input type="text" placeholder="Email Address" name="text" class="info" v-model="user.username">
                <input type="email" placeholder="Password" name="email" class="info" v-model="user.password">
                <input type="email" placeholder="Confirm Password" name="set_email" class="info" v-model="user.confirmPassword">
              
                
            </div>

            <div class="register_info">
            <h3 id="info">Personal Information</h3>

                <div class="more_info">
                   
                        <label for="" class="sex_label">Firstname:</label>
                        <span class="typespan">
                             <input type="text" placeholder="Firstname" name="text" v-model="profile.firstname">
                          
                        </span>
                        
                    
                </div>

                <div class="more_info">
                   
                        <label for="" class="sex_label">Lastname:</label>
                        <span class="typespan">
                             <input type="text" placeholder="Lastname" name="text" v-model="profile.lastname">
                          
                        </span>
                        
                    
                </div>
            
                <div class="more_info">
                    <div class="sex">
                        <label for="" class="sex_label">Sex:</label>
                        <span class="typespan">
                            <input type="radio" class="sex_radio" name="sex"> Male
                            <input type="radio" class="sex_radio" name="sex"> Female
                        </span>
                    
                    </div>
                    <div class="birth">
                        <label for="" class="birth_label">Born:</label>
                        <span class="typespan">
                        <select name="dayselect" id="day">
                            <option value="1">1</option> 
                            <option value="1">2</option>
                            <option value="1">3</option>  
                            <option value="1">4</option>
                            <option value="1">5</option> 
                            <option value="1">6</option> 
                            <option value="1">7</option> 
                            <option value="1">8</option> 
                            <option value="1">9</option> 
                            <option value="1">10</option> 
                            <option value="1">11</option> 
                            <option value="1">12</option> 
                                <option value="1">13</option> 
                            <option value="1">14</option>
                            <option value="1">15</option>  
                            <option value="1">16</option>
                            <option value="1">17</option> 
                            <option value="1">18</option> 
                            <option value="1">19</option> 
                            <option value="1">20</option> 
                            <option value="1">21</option> 
                            <option value="1">22</option> 
                            <option value="1">23</option> 
                            <option value="1">24</option>
                            <option value="1">25</option>
                            <option value="1">26</option>
                            <option value="1">27</option>
                            <option value="1">28</option>
                            <option value="1">29</option>
                            <option value="1">30</option>
                            <option value="1">31</option>
                            </select>
                            <select name="monthselect" id="month">
                                <option value="January">January</option>
                                <option value="February">February</option>
                                <option value="March">March</option>
                                <option value="April">April</option>
                                <option value="May">May</option>
                                <option value="June">June</option>
                                <option value="July">July</option>
                                <option value="August">August</option>
                                <option value="September">September</option>
                                <option value="October">October</option>
                                <option value="November">November</option>
                                <option value="December">December</option>
                            </select>
                            <input type="number" id="year" name="year" value="1988" maxlength="4" max="2021" min="1910">
                        </span>
                    
                    </div>
                    <div class="height">
                        <label for="" class="height_label">Height:</label>
                        <span class="typespan">
                            <select name="height_feet" id="height_feet">
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                                <option value="7">7</option>
                                <option value="8">8</option>
                            </select>
                            feet
                            <select name="height_inches" id="height_inches">
                                <option value="0">0</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                                <option value="7">7</option>
                                <option value="8">8</option>
                                <option value="1">9</option>
                                <option value="1">10</option>
                                <option value="1">11</option>
                        </select>
                        inches
                      
                        </span>
                    
                    </div>
                    <div class="weight">
                        <label for="" class="weight_label">Weight:</label>
                        <span class="typespan">
                            <input type="number" id="weight_num" name="weight" maxlength="4" min="1" value="150" max="2000" v-model="profile.currentweight">
                           lbs   
                           
                        </span>
                    
                    </div>

                    <div class="weight">
                        <label for="" class="goal_weight">Goal Weight:</label>
                        <span class="typespan">
                            <input type="number" id="weight_num" name="weight" maxlength="4" min="1" value="150" max="2000" v-model="profile.goalweight">
                           lbs
                               
                        </span>
                    
                    </div>
                </div>
                
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
            profile: {
                firstname: '',
                lastname: '',
                height: '',
                currentweight: '',
                goalweight: '',
                birthday: '',

            }
        }
    },
    registrationError: false,
    registrationErrorMsg: "Please sign in with the correct username or password", 
    methods: {
        registerUser() {
            if(this.user.password != this.user.username) {
                this.registration = true;
                alert(this.registrationErrorMsg);

            }else {
                authService
                .registerUser()
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
        height: 10rem;
        margin: 0 auto;
        padding: 30px;
        margin-top: 20px;
        margin-bottom: 10px;
        border: 1px solid #eee;
        border-radius: 10px;
        background: #fefefe;
        
       
    }

     .register_info {
        max-width: 500px;
        height: 20rem;
        margin: 0 auto;
        padding: 30px;
        margin-top: 20px;
        margin-bottom: 10px;
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
        border-radius: 5px;
        border: 1px solid #ccc;
        box-sizing: border-box;
    }

    .sex {
        margin-bottom: 10px;
    }

    .birth {
        margin-bottom: 10px;
    }

    .height {
        margin-bottom: 10px;
    }

    .weight {
        margin-bottom: 10px;
    }
    
    #height_inches {
        margin-left: 10px;
    }
    #height_feet {
        padding-right: 4px;
    }

  

    #month {
        margin-left: 10px;
    }

    #year {
        margin-left: 10px;
    }
    
    #height_cm {
        margin-right: 10px;
    }
    .typespan 

   #weight_num {
        margin-right: 10px;
    }

 
    form {
        display: block;
        
    }

    .typespan {
        margin-left: 15px;
        display: inline-block;
        text-align: left;
        width: 50%;
        padding-left: 50px;
    
    }

    .register_info h3 {
        display: block;
        font-size: 1.15em;
        font-weight: bold;
        margin-left: 50px;
    }

    .more_info {
        margin-top: 20px;
      
     
    }

    .submit {
        width: 560px;
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

 
    

 

 

</style>