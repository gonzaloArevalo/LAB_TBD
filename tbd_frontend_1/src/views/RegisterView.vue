<template>
    <v-container class="register-container" fluid>
      <v-row justify="center">
        <v-col cols="12" md="4">
          <v-card class="pa-6">
            <v-card-title class="text-h5">Registrarse</v-card-title>
            <v-card-subtitle class="v-card-sub">
              <span>¿Tienes una cuenta?</span>
            </v-card-subtitle>
            <v-btn color="primary" class="ml-1" :to="{ name: 'Login' }">Iniciar Sesión</v-btn>
            <v-card-text>
              <v-form @submit.prevent="handleSubmit">
                <v-text-field
                  v-model="email"
                  label="Correo"
                  placeholder="tu@ejemplo.com"
                  prepend-inner-icon="mdi-email"
                  outlined
                  dense
                  :rules="[rules.required,rules.sameEmail]"
                  @click="sameEmail ? (sameEmail = !sameEmail): null"
                ></v-text-field>
                <v-text-field
                  v-model="name"
                  label="Nombre"
                  placeholder="Ingresa tu nombre"
                  prepend-inner-icon="mdi-account"
                  outlined
                  dense
                  :rules="[rules.required]"
                ></v-text-field>
                <v-text-field
                  v-model="direccion"
                  label="Dirección"
                  placeholder="Ingresa tu dirección"
                  prepend-inner-icon="mdi-map-marker"
                  outlined
                  dense
                  :rules="[rules.required]"
                ></v-text-field>
                <v-text-field
                  v-model="telefono"
                  label="Teléfono"
                  placeholder="Ingresa tu número telefónico"
                  prepend-inner-icon="mdi-phone"
                  outlined
                  dense
                  :rules="[rules.required]"
                ></v-text-field>
                <v-text-field
                  v-model="password"
                  :rules="[rules.required]"
                  label="Contraseña"
                  placeholder="Ingresa tu contraseña"
                  prepend-inner-icon="mdi-lock"
                  outlined
                  dense
                  :type="show1 ? 'text' : 'password'"
                  :append-inner-icon="show1 ? 'mdi-eye' : 'mdi-eye-off'"
                  @click:append-inner="show1 = !show1"
                ></v-text-field>
                <v-text-field
                  v-model="confirmPassword"
                  :rules="[rules.required, rules.passwordMatch]"
                  label="Confirmar contraseña"
                  placeholder="Confirma tu contraseña"
                  prepend-inner-icon="mdi-lock-check"
                  outlined
                  dense
                  :type="show2 ? 'text' : 'password'"
                  :append-inner-icon="show2 ? 'mdi-eye' : 'mdi-eye-off'"
                  @click:append-inner="show2 = !show2"
                ></v-text-field>
                <v-btn class="mt-1" type="submit" color="primary">Registrarse</v-btn>
              </v-form>
            </v-card-text>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </template>
  
  <script>
  export default {
    name: "Register",
    data() {
      return {
        email: '',
        password: '',
        confirmPassword: '',
        name: '',
        direccion: '',
        telefono: '',
        show1: false,
        show2: false,
        sameEmail: false,
        rules: {
          required: value => !!value || 'Requerido.',
          passwordMatch: value => value === this.password || 'La contraseña no coincide con la anterior.',
          sameEmail: () => !this.sameEmail || 'Este correo ya está registrado.'
        }
      };
    },
    methods: {
      handleSubmit() {
        console.log(this.email);
        console.log(this.password);

        // SI NO ESTAN LOS CAMPOS NO SE REGISTRA

        // SI DE LO QUE ENTREGA EL BACK SE DICE QUE EL CORREO YA ESTA REGISTRADO SE HACE LO SGTE Y NO SE REGISTRA
        // this.sameEmail = !this.sameEmail;
      } 
    }
  };
  </script>
  
  <style scoped>
  .register-container {
    height: 100vh;
    display: flex;
    align-items: center;
    background-image: url('../assets/yotsuba.jpg');
    background-size: cover; /* Cubre toda la pantalla */
    background-position: center; /* Centra la imagen */
    background-repeat: no-repeat; /* Evita que se repita la imagen */
  }
  
  .v-card {
    border-radius: 12px;
  }
  
  .v-card-title {
    font-weight: bold;
  }
  
  .v-card-sub {
    display: inline;
  }
  </style>
  
    