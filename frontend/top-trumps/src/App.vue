<template>
  <div>
    <img alt="Vue logo" src="./assets/logo.png">
    <!-- <HelloWorld msg="Welcome to Your Vue.js App"/> -->
    <CardSlide />
    <hr />
    <p>VUE_APP_PROP={{ prop }}</p>
    <p>FOO={{ foo }}</p>
    <hr />
  </div>
</template>

<script>
import CardSlide from './components/CardSlide.vue'

export default {
  name: 'App',
  components: {
    CardSlide
  },
  data(){
      return {
        prop: process.env.VUE_APP_PROP,
        foo: process.env.VUE_APP_FOO
    }
  },
  created() {
    var url = process.env.VUE_APP_URL;
    var newGame = process.env.VUE_APP_PATH_NEW_GAME;
    // var getDeck = process.env.VUE_APP_PATH_DECK;
    fetch(url + newGame, {
        method: 'get',
        headers: {
          'content-type': 'application/json'
        }
      })
      .then(response => response.json())
      .then(data => {
        console.log(data.playerDeck)
        this.CardSlide.cards = data.playerDeck
        });
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
