package jadeproject;
import jade.core.Agent;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class JadeProject {

    public static void main(String[] args) {
        Runtime r = Runtime.instance();
        Profile pro = new ProfileImpl("localhost",1000,"platform");
        ContainerController main = r.createMainContainer(pro);
        try {
            AgentController a = main.createNewAgent("a","jadeproject.a", null);
            a.start();
            AgentController b = main.createNewAgent("b","jadeproject.b", null);
            b.start();
            AgentController c = main.createNewAgent("c","jadeproject.c", null);
            c.start();
            AgentController d = main.createNewAgent("d","jadeproject.d", null);
            d.start();
            AgentController e = main.createNewAgent("e","jadeproject.e", null);
            e.start();
            AgentController f = main.createNewAgent("f","jadeproject.f", null);
            f.start();
            AgentController g = main.createNewAgent("g","jadeproject.g", null);
            g.start();
            AgentController h = main.createNewAgent("h","jadeproject.h", null);
            h.start();
            AgentController i = main.createNewAgent("i","jadeproject.i", null);
            i.start();
            AgentController j = main.createNewAgent("j","jadeproject.j", null);
            j.start();
            AgentController k = main.createNewAgent("k","jadeproject.k", null);
            k.start();
            AgentController l = main.createNewAgent("l","jadeproject.l", null);
            l.start();
            AgentController m = main.createNewAgent("m","jadeproject.m", null);
            m.start();
            AgentController n = main.createNewAgent("n","jadeproject.n", null);
            n.start();
            AgentController o = main.createNewAgent("o","jadeproject.o", null);
            o.start();
            AgentController p = main.createNewAgent("p","jadeproject.p", null);
            p.start();
            AgentController center = main.createNewAgent("center","jadeproject.center", null);
            center.start();
//            a.kill();
//            b.kill();
//            c.kill();
//            d.kill();
//            e.kill();
//            f.kill();
//            g.kill();
//            h.kill();
//            i.kill();
//            j.kill();
//            k.kill();
//            l.kill();
//            m.kill();
//            n.kill();
//            o.kill();
//            p.kill();
        } catch (StaleProxyException ex) {
            Logger.getLogger(JadeProject.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
