<template>
    <div class="row">
      <div class="col-lg-8 col-md-7">
        <div class="card">
    <div class="content">
      <form @submit="update">
        <div class="row">
          <div class="col-md-5">
            <fg-input type="text"
                      label="서비스ID"
                      :disabled="true"
                      v-validate="'required|서비스ID'"
                      v-model="data.service_id">
            </fg-input>
            <span class="error" v-if="errors.has('서비스ID')">{{errors.first('서비스ID')}}</span>
          </div>
          <div class="col-md-3">

            <fg-input type="text"
                      label="서비스명"
                      v-validate="'required|서비스명'"
                      v-model="data.service_name">
            </fg-input>
            <span class="error" v-if="errors.has('서비스명')">{{errors.first('서비스명')}}</span>
          </div>
          <div class="col-md-4">
            <fg-input type="text"
                      :disabled="true"
                      label="등록일"
                      v-model="data.rgst_dtm">
            </fg-input>
          </div>
        </div>

        <div class="row">
          <div class="col-md-6">
            <fg-input type="text"
                      label="column1"
                      placeholder="column1"
                      >
            </fg-input>
          </div>
          <div class="col-md-6">
            <fg-input type="text"
                      label="column2"
                      placeholder="column2"
                      >
            </fg-input>
          </div>
        </div>

        <div class="row">
          <div class="col-md-12">
            <fg-input type="text"
                      label="column3"
                      placeholder="column3"
                      >
            </fg-input>
          </div>
        </div>

        <div class="row">
          <div class="col-md-4">
            <fg-input type="text"
                      label="column4"
                      placeholder="column4"
                      >
            </fg-input>
          </div>
          <div class="col-md-4">
            <fg-input type="text"
                      label="column5"
                      placeholder="column5">
            </fg-input>
          </div>
          <div class="col-md-4">
            <fg-input type="number"
                      label="column6"
                      placeholder="column6"
                      >
            </fg-input>
          </div>
        </div>

        <div class="row">
          <div class="col-md-12">
            <div class="form-group">
              <label>Description</label>
              <textarea rows="5" class="form-control border-input"
                        v-model="data.description">

              </textarea>
            </div>
          </div>
        </div>
        <div class="text-center">
          <button type="button" class="btn btn-default btn-fill btn-wd"  @click="back()">
           뒤로
          </button>
          <button type="submit" class="btn btn-success btn-fill btn-wd">
            수정
          </button>
          <button type="button" class="btn btn-danger btn-fill btn-wd"  @click="del()">
            삭제
          </button>
        </div>
        <div class="clearfix"></div>
      </form>
    </div>
  </div>
      </div>
    </div>
</template>
<script>
   export default {
    props: ['service_id'],
    data () {
      return {
          data: [],
          service_id: ''
      }
    },
    created: function () {
    this.get()
    },
    methods: {
      get: function () {
        this.$axios.get(`/api/getSvcDetail`, {params: {'service_id': this.service_id}})
        .then(response => {
          this.data = response.data.data[0]
        })
      },
      update: function () {
        //this.$validator.validateAll()
        console.log(this.data)
        if (!this.errors.any()) {
           this.$axios.post(`/api/updateSvc`, this.data)
          .then(response => {
            this.$swal({
              title: "서비스정보가 변경 되었습니다.",
              text: "서비스 ID : "+ this.service_id,
              icon: "success",
            })
          })
        }
      },
      del: function () {
        if(confirm("서비스를 삭제 하시겠습니까?")){
           this.$axios.delete(`/api/deleteSvc`, {params: {'service_id': this.service_id}})
          .then(response => {
            this.$swal({
              title: "서비스정보가 삭제 되었습니다.",
              text: "서비스 ID : "+ this.service_id,
              icon: "success",
            }).then((value) => {
              this.back()
            });
          })
        }
      },
      proc: function () {
        cafes.patch(this.cafe).then((res) => {
          this.$router.replace('/table-list')
        })
      },
      back: function () {
        this.$router.go(-1)
      }
    }
  }
</script>
<style>
span.error {
  color: #9F3A38;
}

</style>
