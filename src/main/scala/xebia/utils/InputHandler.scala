package xebia.utils

import javax.naming.directory.InvalidAttributesException

import utils.Logger

import scala.io.Source
import xebia.homework._

import scala.util.{Failure, Success, Try}

case class NotSupportedCaracter(message: String) extends Exception(message: String)

object InputHandler extends Logger{

  def apply() = new InputHandler()

  def main(args: Array[String]) = {

    if(args.isEmpty){
      throw new InvalidAttributesException()
    }

    val itr = InputHandler().fileHandler(args(0))
    itr match {
      case Success(itr) => {
        val bornes = InputHandler().getBornesFromLine(itr.next())
        while (itr.hasNext) {
          val tondeuse = InputHandler().getPositionFromLine(itr.next())
          val instructions = itr.next()
          bornes.map(bornes => {
            tondeuse.map(t => {
              println(TondeuseService().moveOnSequence(t, bornes , instructions))
            })
          })
        }
      }
      case Failure(ex) => throw ex
    }

  }

}

class InputHandler extends Logger {

  def fileHandler(filename: String): Try[Iterator[String]] ={
      Try(Source.fromFile(filename).getLines())
  }

  def getBornesFromLine(str : String): Option[Position] = {
      str.split(" ").map(_.toInt) match {
        case Array(x, y) => Some(Position(x, y))
        case _ => LOG.severe("can not extract bornes from Input")
          None
      }
  }

  def getPositionFromLine(str: String) : Option[Tondeuse] = {
    str.split(" ") match {
      case Array(x, y, n) => Some(Tondeuse(Position(x.toInt, y.toInt), Direction.withName(n)))
      case _ => LOG.severe("can Not extract Position from Input")
        None
    }
  }

}