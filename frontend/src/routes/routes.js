import DashboardLayout from '../components/Dashboard/Layout/DashboardLayout.vue'
// GeneralViews
import NotFound from '../components/GeneralViews/NotFoundPage.vue'

// Admin pages
import UserProfile from 'src/components/Dashboard/Views/UserProfile.vue'
import Icons from 'src/components/Dashboard/Views/Icons.vue'
import TableList from 'src/components/Dashboard/Views/TableList.vue'
import ServiceDetail from 'src/components/Dashboard/Views/ServiceDetail.vue'
import ServiceAdd from 'src/components/Dashboard/Views/ServiceAdd.vue'


const routes = [
  {
    path: '/',
    component: DashboardLayout,
    redirect: '/table-list'
  },
  {
    path: '/',
    component: DashboardLayout,
    redirect: '/table-list',
    children: [
      {
        path: 'stats',
        name: 'stats',
        component: UserProfile
      },
      {
        path: 'icons',
        name: 'icons',
        component: Icons
      },
      {
        path: 'table-list',
        name: '서비스 카탈로그',
        component: TableList
      },
      {
        path: 'service/:service_id',
        name: '서비스 상세',
        component: ServiceDetail,
        props: true
      },
      {
        path: 'svcAdd',
        name: '서비스 등록',
        component: ServiceAdd
      }
    ]
  },
  { path: '*', component: NotFound }
]

/**
 * Asynchronously load view (Webpack Lazy loading compatible)
 * The specified component must be inside the Views folder
 * @param  {string} name  the filename (basename) of the view to load.
function view(name) {
   var res= require('../components/Dashboard/Views/' + name + '.vue');
   return res;
};**/

export default routes
