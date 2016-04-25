package xebia.homework

case class Position(x: Int, y: Int)

case class Tondeuse(p: Position, direction: Direction.Value) {

   def move(): Tondeuse = {
    val newPoisition = direction match {
      case Direction.N => Position(p.x, p.y + 1)
      case Direction.S => Position(p.x, p.y - 1)
      case Direction.W => Position(p.x - 1, p.y)
      case Direction.E => Position(p.x + 1, p.y)
      case _ => p
    }
    Tondeuse(newPoisition, direction)
  }

   def oriente(rotate: Char): Tondeuse = {
    val newDirection = rotate match {
      case 'D' => {
        Direction.orientation((Direction.orientation.indexOf(direction) + 1) % 4) // orientation en cycle à droite de 4 direction, dans le sens : (nord, est, sud, west)
      }
      case 'G' => {
        Direction.orientation((Direction.orientation.indexOf(direction) + 3) % 4) // orientation en cycle à gauche de 4 direction, dans le sens : (nord, est, sud, west)
      }
      case _ => direction
    }
    Tondeuse(p, newDirection)
  }

  override def toString() = {
    p.x.toString+ " " + p.y.toString+ " " + direction
  }


}

