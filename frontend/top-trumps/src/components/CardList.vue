<template>
	<div>
		<span v-if="cards.length">
			<Card
				v-for="card in cards"
				:key="card.id"
				:card="card"
				@remove="removeCard"
			/>
		</span>
		<p v-else>
			Nothing left in the list. Add a new card in the input above.
		</p>
	</div>
</template>

<script>
import Card from './Card.vue'
let nextCardId = 0
export default {
	components: {
		Card
	},
  data () {
    return {
      cards: [
				{
					id: nextCardId++,
          hp: 100,
          name: 'Charmander',
          power: 'Fire',
					weakness: 'Water',
          strength: 30,
          magic: 10,
          telekinesis: 100,
          speed: 30,
          iq: 50
				},
				{
					id: nextCardId++,
          hp: 100,
          name: 'Squirtle',
          power: 'Water',
					weakness: 'Electricity',
          strength: 20,
          magic: 80,
          telekinesis: 20,
          speed: 40,
          iq: 100
				},
				{
					id: nextCardId++,
          hp: 100,
          name: 'Bulbasaur',
          power: 'Grass',
					weakness: 'Fire',
          strength: 40,
          magic: 20,
          telekinesis: 20,
          speed: 80,
          iq: 30
				}
			]
    }
  },
	methods: {
		addCard () {
			const trimmedText = this.newTodoText.trim()
			if (trimmedText) {
				this.cards.push({
					id: nextCardId++,
          hp: 100,
          name: 'Pikachu',
          power: 'Electricity',
					weakness: 'Ground',
          strength: 40,
          magic: 20,
          telekinesis: 20,
          speed: 60,
          iq: 110
				})
				this.newTodoText = ''
			}
		},
		removeCard (idToRemove) {
			this.cards = this.cards.filter(card => {
				return card.id !== idToRemove
			})
		}
	}
}
</script>
