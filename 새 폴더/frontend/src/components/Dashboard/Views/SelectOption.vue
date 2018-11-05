<template>
  <el-option :value="value" :label="label" :disabled="disabled" :class="{ 's-warn': warn, 's-info': info, 's-debug': debug }"><slot/></el-option>
</template>

<script>
 import { Option } from 'element-ui'

export default {
   extends: Option,
  props: {
    value: {
      type: [ String, Number ]
    },
    label: {
      type: String
    },
    disabled: {
      type: Boolean
    },
    warn: {
      type: Boolean
    },
    info: {
      type: Boolean
    },
    debug: {
      type: Boolean
    }
  },
  watch: {
    value () {
      console.log(this)
    }
  }
}
</script>

<style scoped>
</style>
