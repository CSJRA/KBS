package test;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;

import net.sf.clipsrules.jni.*;

public class ClipsAgent extends Agent {

  Environment clips;
  protected void setup() {
  //try{
    clips = new Environment();
  //}catch(Exception e){}
    addBehaviour(new TellBehaviour());
    addBehaviour(new AskBehaviour());
  } 

  private class TellBehaviour extends Behaviour {

    boolean tellDone = false;

    public void action() {
	//try{
	clips.eval("(clear)");

        clips.eval("(assert (sintoma a))");
        clips.eval("(assert (sintoma b))");
	//}catch(Exception e){}
	tellDone = true;

    } 
    
    public boolean done() {
      if (tellDone)
        return true;
      else
	return false;
    }
  }

private class AskBehaviour extends Behaviour {

    boolean askDone = false;

    public void action() {
	//try{
	clips.eval("(facts)");
	//}catch(Exception e){}
	askDone = true;
    } 
    
    public boolean done() {
      if (askDone)
        return true;
      else
	return false;
    }
   
    public int onEnd() {
      myAgent.doDelete();
      return super.onEnd();
    } 
  }    // END of inner class ...Behaviour
}
