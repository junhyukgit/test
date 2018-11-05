import Sidebar from './SideBar.vue'

const SidebarStore = {
  showSidebar: false,
  sidebarLinks: [
    {
      name: 'User Profile',
      icon: 'ti-user',
      path: '/stats'
    },
    {
      name: 'Service List',
      icon: 'ti-view-list-alt',
      path: '/table-list'
    },
    {
      name: 'Icons',
      icon: 'ti-pencil-alt2',
      path: '/icons'
    }
  ],
  displaySidebar (value) {
    this.showSidebar = value
  }
}

const SidebarPlugin = {

  install (Vue) {
    Vue.mixin({
      data () {
        return {
          sidebarStore: SidebarStore
        }
      }
    })

    Object.defineProperty(Vue.prototype, '$sidebar', {
      get () {
        return this.$root.sidebarStore
      }
    })
    Vue.component('side-bar', Sidebar)
  }
}

export default SidebarPlugin
