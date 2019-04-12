import Vue from 'vue'
import Router from 'vue-router'
import Index from '@/pages/index'
import Rob from '@/pages/rob'
import Trip from '@/pages/trip'
import Order from '@/pages/order'
import Mine from '@/pages/mine'

import Login from '@/pages/login';
import Reg from '@/pages/reg';

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'index',
      component: Index
    },
    {
      path: '/rob',
      name: 'rob',
      component: Rob
    },
    {
      path: '/trip',
      name: 'trip',
      component: Trip
    },
    {
      path: '/order',
      name: 'order',
      component: Order
    },
    {
      path: '/mine',
      name: 'mine',
      component: Mine
    },
    {
      path: '/login',
      name: 'login',
      component: Login
    },
    {
      path: '/reg',
      name: 'reg',
      component: Reg
    }
  ]
})
