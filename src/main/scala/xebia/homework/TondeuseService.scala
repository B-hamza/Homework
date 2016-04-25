package xebia.homework

import utils.Logger


object TondeuseService {

  def apply() = new TondeuseService()
}


class TondeuseService extends Logger{


  def checkTondeuseInBorn(tondeuse: Tondeuse, positionBorne: Position): Boolean = {
    val position = tondeuse.p
      (position.x == positionBorne.x && tondeuse.direction.equals(Direction.E)) ||
      (position.x == 0 && tondeuse.direction.equals(Direction.W)) ||
      (position.y == positionBorne.y && tondeuse.direction.equals(Direction.N)) ||
      (position.y == 0 && tondeuse.direction.equals(Direction.S))
  }

  def moveOnInstruction(tondeuse: Tondeuse, positionBorne: Position, instr: Char): Tondeuse = {
    instr match {
      case 'A' => {
        if(!checkTondeuseInBorn(tondeuse, positionBorne)) {
          tondeuse.move()
        }
        else {
          LOG.warning(s"Can not move beyound the bounds")
          tondeuse
        }
      }
      case 'G' => tondeuse.oriente(instr) // G or D
      case 'D' => tondeuse.oriente(instr)
      case _ => LOG.severe(s"$instr is not supported as instruction !")
        tondeuse
    }
  }

  def moveOnSequence( tond: Tondeuse, positionBorne: Position,seq: String): Tondeuse = {
    seq.foldLeft(tond){
      (tondeuse, c) => moveOnInstruction(tondeuse, positionBorne, c)
    }
  }

}
