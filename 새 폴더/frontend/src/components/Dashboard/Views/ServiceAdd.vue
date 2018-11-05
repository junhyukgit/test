<template>
    <div class="row">
      <div class="col-lg-8 col-md-7">
        <div class="card">
    <div class="content">
      <form @submit="Add">
        <div class="row">
          <fg-input type="hidden"
                      v-model="data.chrgr_met_id">
            </fg-input>
          <div class="col-md-12">
            <fg-input type="text"
                      label="서비스명"
                      v-model="data.service_name">
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
          <button type="submit" class="btn btn-info btn-fill btn-wd">
            등록
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
    data () {
      return {
          data: {}
      }
    },
    created: function () {
    },
    methods: {
      Add: function () {
        console.log(this.data)
        this.data.chrgr_met_id = '김준혁'
           this.$axios.post(`/api/addSvc`, this.data)
          .then(response => {
            this.$swal({
              title: "서비스가 등록 되었습니다.",
              text: "",
              icon: "success",
            }).then((value) => {
              this.back()
            });
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
