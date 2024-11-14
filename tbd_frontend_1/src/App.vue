

<script>
import Navbar from './components/Navbar.vue';
import Sidemenu from './components/Sidemenu.vue';
export default {
  name: 'App',
  data() {
    return {
    }
  },
  components: {
    Navbar,
  },
  methods: {
  },

  
}
</script>

<template>

  <v-app>
    <Navbar />

    <v-content>

      <router-view />

    </v-content>


  </v-app>
  

</template>

<style>

</style>
