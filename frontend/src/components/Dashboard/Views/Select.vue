<template>
  <el-select :value="data" :disabled="readonly || disabled" @change="doChange($event)" :class="{ 's-input-readonly': readonly, 's-input-disabled': disabled }">
    <el-option v-if="!!label" :value="null" :label="label"/>
    <el-option v-for="(option, index) in options" :key="index" :value="getValue(option)" :label="getLabel(option)" :disabled="isDisabled(option)" :class="{ 's-warn': isWarn(option), 's-info': isInfo(option), 's-debug': isDebug(option) }"/>
    <slot/>
  </el-select>
</template>

<script>
export default {
  model: {
    prop: 'data',
    event: 'change'
  },
  props: {
    data: {
      type: [ String, Number ]
    },
    label: {
      type: String
    },
    readonly: {
      type: Boolean,
      default: false
    },
    disabled: {
      type: Boolean,
      default: false
    },
    options: {
      type: Array
    },
    optionValue: {
      type: String
    },
    optionLabel: {
      type: [ String, Function ]
    },
    optionDisabled: {
      type: String
    },
    optionWarn: {
      type: String
    },
    optionInfo: {
      type: String
    },
    optionDebug: {
      type: String
    }
  },
  $_veeValidate: {
    value () {
      return this.data
    }
  },
  methods: {
    getValue (option) {
      return this.optionValue ? option[this.optionValue] : option
    },
    getLabel (option) {
      if (this.optionLabel) {
        if (this.$util.isString(this.optionLabel)) {
          return option[this.optionLabel]
        } else {
          return this.optionLabel(option)
        }
      } else {
        return option
      }
    },
    isDisabled (option) {
      return this.optionDisabled && option[this.optionDisabled]
    },
    isWarn (option) {
      return this.optionWarn && option[this.optionWarn]
    },
    isInfo (option) {
      return this.optionInfo && option[this.optionInfo]
    },
    isDebug (option) {
      return this.optionDebug && option[this.optionDebug]
    },
    doChange (value) {
      this.$emit('change', value)
    }
  }
}
</script>

<style scoped>
</style>
