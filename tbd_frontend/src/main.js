import './assets/main.css'

import { createApp } from 'vue'
import App from './App.vue'
import router from './router'

// Importa Vuetify y los estilos
import { createVuetify } from 'vuetify'
import 'vuetify/styles'

// Crear la instancia de Vuetify
const vuetify = createVuetify()

// Crear la app e integrar Vuetify y el enrutador
const app = createApp(App)

app.use(router)
app.use(vuetify) // Integrar Vuetify 

app.mount('#app')