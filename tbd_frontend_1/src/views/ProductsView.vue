<template>
    <div class="mx-6 mt-5">
      <h1 class="mb-5 ml-5">Productos</h1>
      
      <v-container fluid>
        <v-row>
          <v-col v-for="n in 10" :key="n" cols="12" sm="6" md="4" lg="3">
            <v-card class="product-card pt-10">
              <v-img src="../assets/yotsuba.jpg" class="product-image mb-3"></v-img>
              
              <v-card-title class="text-h5 text-center">Nombre producto</v-card-title>
              
              <v-card-subtitle class="text-center mb-3">
                Producto de categoría x
              </v-card-subtitle>

              <v-btn class="mb-2" color="primary" outlined>Detalles</v-btn>
              <v-btn class="mb-2" color="primary">Agregar al carrito</v-btn>
            </v-card>
          </v-col>
        </v-row>
      </v-container>
    </div>
  </template>
  
  <script>
  export default {};
  </script>
  
  <style scoped>
  .product-card {
    display: flex;
    flex-direction: column;
    align-items: center;
    padding: 16px;
    box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
    border-radius: 12px;
    transition: transform 0.3s ease;
  }
  
  .product-card:hover {
    transform: scale(1.03); /* Añade un pequeño efecto de aumento al pasar el mouse */
  }
  
  .product-image {
    border-radius: 8px;
    width: 100%;
    max-width: 150px;
    height: auto;
  }
  
  h1 {
    font-weight: bold;
    font-size: 2.5rem;
    color: #333;
    text-transform: uppercase;
  }
  
  .text-center {
    text-align: center;
  }
  </style>