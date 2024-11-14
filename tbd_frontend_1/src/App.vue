<script>
import Navbar from './components/Navbar.vue';
import Sidemenu from './components/Sidemenu.vue';
export default {
  name: "App",
  components: {
    Sidemenu,
  },
  data() {
    return {
      menuDrawer: false,
      cartDrawer: false,
      mostrarNavbar: true
    };
  },
  watch: {
    // Observa la ruta actual y actualiza `mostrarNavbar` cuando cambia
    $route(to) {
      this.mostrarNavbar = !["Login", "Register"].includes(to.name);
    }
  },
  methods: {
  mounted() {
    // Configura `mostrarNavbar` inicialmente basado en la ruta actual
    this.mostrarNavbar = !["Login", "Register"].includes(this.$route.name);
    },
  },
  methods: {
    toggleMenuDrawer() {
      this.menuDrawer = !this.menuDrawer;
    },
    toggleCartDrawer() {
      this.cartDrawer = !this.cartDrawer;
    },
    logout() {
      // Elimina el token del localStorage
      localStorage.removeItem("token");

      // Redirige al usuario a la vista de Login
      this.$router.push({ name: "Login" });
    }
  }
};
</script>

<template>
  <v-app>
    <Navbar />
    <!-- Navbar con botón para abrir el drawer -->
    <v-app-bar v-if="mostrarNavbar" app>
      <v-app-bar-nav-icon @click="toggleMenuDrawer" />
      <v-toolbar-title>Mi Tienda</v-toolbar-title>
      <v-spacer></v-spacer>

      <v-btn text to="/" :exact="true">Inicio</v-btn>
      <v-btn text to="/products">Productos</v-btn>

      <!-- Botón de carrito -->
      <v-btn icon @click="toggleCartDrawer">
        <v-icon>mdi-cart</v-icon>
      </v-btn>

      <!-- Botón de cerrar sesión -->
      <v-btn color="primary" @click="logout">
        Cerrar Sesión
      </v-btn>
    </v-app-bar>

    <Sidemenu v-model="menuDrawer" />

    <v-navigation-drawer
      v-model="cartDrawer"
      app
      :right="true"
      position="right"
      temporary
      width="300"
      color="grey lighten-4"
      style="position: fixed;"
    >
      <v-list>
        <v-list-item>
          <v-list-item-title>Carrito de Compras</v-list-item-title>
        </v-list-item>
        <!-- Agrega aquí el contenido del carrito -->
      </v-list>
    </v-navigation-drawer>

    <v-content>
      <router-view />
    </v-content>
  </v-app>
</template>

<style>
/* Aquí puedes agregar tus estilos adicionales */
</style>