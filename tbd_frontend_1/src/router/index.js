import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import AboutView from '@/views/AboutView.vue'
import LoginView from '@/views/LoginView.vue'
import RegisterView from '@/views/RegisterView.vue'
import ProductsView from '@/views/ProductsView.vue'
import ClientView from '@/views/ClientView.vue'

const routes = [
  {
    path: '/',
    name: 'Home',
    component: HomeView,
    meta: { requiresAuth: true } 
  },
  {
    path: '/about',
    name: 'About',
    component: AboutView,
    meta: { requiresAuth: true } 
  },
  {
    path: '/login',
    name: 'Login',
    component: LoginView
  },
  {
    path: '/register',
    name: 'Register',
    component: RegisterView 
  },
  {
    path: '/products',
    name: 'Products',
    component: ProductsView,
    meta: { requiresAuth: true } 
  },
  {
    path: '/client',
    name: 'Client',
    component: ClientView
  }

]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

// Guard de navegación global
router.beforeEach((to, from, next) => {
  const token = localStorage.getItem('token'); // Obtenemos el token del localStorage
  const requiresAuth = to.matched.some(record => record.meta.requiresAuth); // Verificamos si la ruta requiere autenticación

  if (requiresAuth && !token) {
    // Si la ruta requiere autenticación y no hay token, redirige al login
    next({ name: 'Login' });
  } else {
    // Si no requiere autenticación o el token está presente, continúa
    next();
  }
});

export default router
