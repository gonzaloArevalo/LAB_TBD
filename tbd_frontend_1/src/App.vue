<script>
import { ref, provide, onMounted, watch } from "vue";

export default {
  name: "App",
  setup() {
    const carrito = ref([]);

    // Cargar carrito desde localStorage al inicio
    onMounted(() => {
      const carritoGuardado = localStorage.getItem("carrito");
      if (carritoGuardado) {
        carrito.value = JSON.parse(carritoGuardado);
      }
    });

    // Guardar carrito en localStorage cada vez que cambia
    watch(carrito, (nuevoCarrito) => {
      localStorage.setItem("carrito", JSON.stringify(nuevoCarrito));
    }, { deep: true });

    const agregarAlCarrito = (producto) => {
      const productoExistente = carrito.value.find(
        (item) => item.id === producto.id
      );

      if (productoExistente) {
        if (productoExistente.cantidad < producto.stock) {
          productoExistente.cantidad += 1;
        } else {
          console.warn("No se puede agregar más de la cantidad en stock");
        }
      } else {
        carrito.value.push({ ...producto, cantidad: 1 });
      }
    };

    const eliminarDelCarrito = (productoId) => {
      const index = carrito.value.findIndex((item) => item.id === productoId);
      if (index !== -1) {
        if (carrito.value[index].cantidad > 1) {
          carrito.value[index].cantidad -= 1;
        } else {
          carrito.value.splice(index, 1);
        }
      }
    };

    provide("carrito", carrito);
    provide("agregarAlCarrito", agregarAlCarrito);
    provide("eliminarDelCarrito", eliminarDelCarrito);

    return {
      carrito,
      drawer: ref(false),
      agregarAlCarrito,
      eliminarDelCarrito,
    };
  },
};
</script>

<template>
  <v-app>
    <!-- Navbar con botón para abrir el drawer -->
    <v-app-bar app>
      <v-toolbar-title>Mi Tienda</v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn icon @click="drawer = !drawer">
        <v-icon>mdi-cart</v-icon>
        <!-- Icono del carrito -->
      </v-btn>
    </v-app-bar>

    <!-- Drawer lateral derecho para el carrito -->
    <v-navigation-drawer location="right" app v-model="drawer">
      <v-list>
        <v-list-item-group>
          <v-list-item v-for="item in carrito" :key="item.id">
            <v-list-item-content>
              <v-list-item-title>{{ item.nombre }}</v-list-item-title>
              <v-list-item-subtitle
                >Cantidad: {{ item.cantidad }}</v-list-item-subtitle
              >
            </v-list-item-content>
            <!-- Aquí usamos eliminarDelCarrito directamente -->
            <v-btn small @click="eliminarDelCarrito(item.id)">Eliminar</v-btn>
          </v-list-item>
        </v-list-item-group>
      </v-list>
    </v-navigation-drawer>

    <!-- Contenido principal -->
    <v-content>
      <router-view />
    </v-content>
  </v-app>
</template>

<style>
/* Estilos opcionales para el drawer */
</style>