<template lang="html">
  <div>
    <section>
      <div class="container-fluid">
        <div class="row">
          <div class="col-lg-2">
            <Menu/>
          </div>
          <div class="col-lg-10">
            <router-view/>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
import Menu from '@/components/menu';

export default {
  name: 'menu',
  components: { Menu }
}
</script>

<style lang="css" scoped>
</style>
