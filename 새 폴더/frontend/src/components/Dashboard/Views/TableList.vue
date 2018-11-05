/* eslint-disable eol-last */
<template>
    <div class="row">
      <div class="col-md-12">
        <div class="card">
          <div>
    <div class="header">
      <slot name="header">
		<br>
		<div class="row">
		<div class="col-md-12">
		<div class="form-group">
		<select class="form-control" v-model="skey" :options="options" style="float: left; width: 20%;">
      <option value="service_name">서비스명</option>
      <option value="service_id">서비스ID</option>
    </select> 
        <input aria-describedby="addon-right addon-left" type="text" class="form-control"  v-model="sval" v-on:keyup.enter="retrieveSvc(sval)" style="float: left; margin-left: 15px; width: 50%;">
		<button class="btn btn-success" type="button" @click="retrieveSvc(sval)" style="margin-left: 2%;"> 검색 </button>
    <button class="btn btn-info" type="button" @click="addSvc()" style="margin-left: 2%; float: right;"> 서비스 등록 </button>
		</div>
		</div>
		</div>
      </slot>
    </div>
    <div>
      <table class="table table-bordered table-hover" :class="tableClass">
        <thead id="j-thead">
          <tr>
          <th width="10%">No</th>
            <th width="10%">서비스ID</th>
            <th width="60%">서비스명</th>
            <th width="10%">담당자</th>
            <th width="15%">등록일</th>
          </tr>
        </thead>
        <tbody>
          <tr class="itemtr" v-for="(item, index) in data" @click="detail(item)">
            <td>{{pagecount+index+1}}</td>
            <td>{{item.service_id}}</td>
            <td>{{item.service_name}}</td>
            <td>{{item.chrgr_met_id}}</td>
            <td>{{item.rgst_dtm}}</td>
          </tr>
        </tbody>
      </table>
      <nav aria-label="..." style="text-align: center;">
      <div class="pagination">
      <vue-ads-pagination
        :total-items=total
        v-on:page-change="pageChange"
        />
      </div>
    </nav>
    </div>
  </div>
        </div>
      </div>


    </div>
</template>
<script>
 // import {AXIOS} from './http-common'
 // import swal from 'sweetalert'
  import VueAdsPagination from 'vue-ads-pagination'
  
  const tableColumns = ['No.', '서비스 ID', '서비스명']

  export default {
    components: {
      VueAdsPagination,
    },
    data () {
      return {
        title: '서비스 카탈로그',
        subTitle: '',
        columns: [...tableColumns],
        data: [],
        errors: [],
        total: '10',
        sval: '',
        skey: 'service_name',
        pagecount : '',
        search_yn : ''
      }
    },
    methods: {
      pageChange (page, range) {
            this.getSvc (page+1)
            this.pagecount = page*10
            console.log(page, range)
      },
      deleteTodo (i) {
        this.todos.splice(i, 1)
      },
      createTodo (name) {
        if (name != null) {
          this.todos.push({name: name})
          this.name = null
        }
      },
      getSvc (v) {
        this.$axios.get(`/api/getSvc`, {params: {page: v,skey: this.skey, sval: this.search_yn}})
          .then(response => {
          // JSON responses are automatically parsed.
            this.data = response.data.data
            this.total = response.data.total
            console.log(response.data.data)
          })
          .catch(e => {
            this.errors.push(e)
          })
      },
      retrieveSvc (search) {
        this.search_yn = search
        this.getSvc(1)
      },
      detail: function (item) {
      this.$router.push('/service/' + item.service_id)
      },
      addSvc: function () {
      this.$router.push('/svcAdd')
      }
    },
    beforeMount () {
      this.getSvc(1)
      /*
      this.$swal({
        title: "Good job!",
        text: "You clicked the button!",
        icon: "success",
      }) */
    }
  }
</script>
<style>
#j-thead{
  background-color: #41B883;
}
#j-thead tr th{
  color : #ffffff;
}
.page-link{
  color :  #41B883;
}
.itemtr{
  cursor: pointer;
}
.ml-1{
  margin: 2px;
}
.leading-normal{
  background-color: white;
  border-color: #f5f5f5;
}
.cursor-default{
  cursor: default;
}
.text-grey{
  color: grey;
}
.bg-grey-light{
  background-color: lightgray;
}
.text-white{
  color: white;
}
.bg-teal-dark{
  background-color: #38a89d;
}
</style>
