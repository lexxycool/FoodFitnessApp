<template>
  <div id="login" class="text-center">
    <form class="form-signin" @submit.prevent="login">
      <div class="member-login">
        <h3 class="h3 mb-3 font-weight-normal">Member Login</h3>
        <div
          class="alert alert-danger"
          role="alert"
          v-if="invalidCredentials"
        >Invalid username and password!</div>
        <div
          class="alert alert-success"
          role="alert"
          v-if="this.$route.query.registration"
        >Thank you for registering, please sign in.</div>
        
        <div class="username-field"> 
          <div class="sr-only">Username: </div>
          <input
            type="text"
            id="username"
            class="form-control"
            placeholder="Username"
            v-model="user.username"
            required
            autofocus
          />
        </div> 
        
        <div class="password-field">
        <div class="sr-only">Password </div>
        <input
          type="password"
          id="password"
          class="form-control"
          placeholder="Password"
          v-model="user.password"
          required
        />
        </div>
        <div class="button-section"><button type="submit">Log In</button>
        </div>
           <div>
        <span>Not a member yet? </span><router-link :to="{ name: 'register' }">Sign up now!</router-link>
      </div>
      </div>

    </form>

  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>
<style >
#login{
  display: flex;
  justify-content: center;
  height: 300px;
}
.member-login{
    display: flex;
    flex-direction: column;
    border: 3px solid #f3f1f1;
    border-radius: 1em;
    padding-left: 20px;
    padding-right: 20px;
    padding-top: 0px;
    padding-bottom: 10px;
    justify-content: space-around;
    align-items: stretch;
    height: 100%;
    width: 100%;
}

.username-field , .password-field, .button-section{
 
  margin-bottom: 10px;
}

.button-section button{
  width: 100%;
  height: 25px;
  border: 1px solid #999999;
  border-radius: 5px;
  font-weight: bold;
  color: #666;
}


.member-login input{
  background-color: #f2f2f2;

  border-top: 1px solid #b2b2b2;
  border-right: 1px solid #d9d9d9;
  border-left: 1px solid #d9d9d9;
  border-bottom: 1px solid #f2f2f2;
  width: 100%;
  height: 25px;  
}

h3{
  font-size: 1em;
  font-weight: normal;
}


.member-login a{
  color: #0072BC;
  text-decoration: none;
}
</style>