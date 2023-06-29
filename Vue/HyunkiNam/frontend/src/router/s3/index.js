import Vue from 'vue'
import VueRouter from 'vue-router'

import S3Page from '@/views/s3/S3Page.vue'
Vue.use(VueRouter)

const s3Routes = [
    {
        path: '/s3-page',
        name: 'S3Page',
        component: S3Page
    },
]

export default s3Routes