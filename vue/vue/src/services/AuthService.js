import axios from 'axios';

export default {

  login(user) {
    return axios.post('/login', user)
  },

  register(user) {
    return axios.post('/register', user)
  }, 

  addUser(user) {
      return axios.post('/signup', user);
  },
  
  addProfile(profile) {
    return axios.post('/profile', profile);
  },


}
