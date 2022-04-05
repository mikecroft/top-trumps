<template>
  <div class="grid">
    <div id="card">
        <span id="hp"><b> HP: {{ card.hp }}</b></span>
        <h2>{{ card.name }}</h2>
        <table>
            <tr>
                <th>Power</th>
                <td>{{ card.power }}</td>
            </tr>
            <tr>
                <th>Weakness</th>
                <td>{{ card.weakness }}</td>
            </tr> 
            <tr>
                <th>Strength</th>
                <td><div class="meter" id="strength" /></td>
            </tr> 
            <tr>
                <th>Magic</th>
                <td><div class="meter" id="magic" /></td>
            </tr> 
            <tr>
                <th>Telekinesis</th>
                <td><div class="meter" id="telekinesis" /></td>
            </tr> 
            <tr>
                <th>Speed</th>
                <td><div class="meter" id="speed" /></td>
            </tr> 
            <tr>
                <th>Intelligence</th>
                <td><div class="meter" id="iq" /></td>
            </tr> 
        </table>
    </div>
  </div>
</template>

<script>
export default {
  data(){ return {
      strength:     this.card.strength + '%',
      magic:        this.card.magic + '%',
      telekinesis:  this.card.telekinesis + '%',
      speed:        this.card.speed + '%',
      iq:           this.card.iq + '%'
    }
  },
  props: {
    card: {
      type: Object,
      required: true
    }
  }

}
</script>

<style scoped>

table {
  text-align: left;
  align-self: center;
  width: 80%;
  padding: 10px, 0px, 50px, 0px;
}

th {
  width: 140px;
}

.meter {
  background-color: blueviolet;
  height: 0.9em;
  border-radius: 5px;
}

#strength     {width: v-bind(strength);}
#magic        {width: v-bind(magic);}
#telekinesis  {width: v-bind(telekinesis);}
#speed        {width: v-bind(speed);}
#iq           {width: v-bind(iq);}


#card {
  grid-column: 2;
  width: 400px;
  padding: 20px 15px 20px 15px;
  margin: 20px;
  background-color: aliceblue;
  border: 2px solid;
  border-radius: 16px;
}

.grid {
  display: grid;
  grid-template-columns: 100px 440px 100px;
  justify-content: space-between;
  align-content: space-between;
}

* {box-sizing: border-box;}

#hp {
  text-align: left;
  width: 100%;
}
</style>