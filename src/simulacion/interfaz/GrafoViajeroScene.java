/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion.interfaz;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import java.util.Collections;
import org.netbeans.api.visual.action.ActionFactory;
import org.netbeans.api.visual.action.SelectProvider;
import org.netbeans.api.visual.action.WidgetAction;
import org.netbeans.api.visual.anchor.AnchorFactory;
import org.netbeans.api.visual.anchor.AnchorShape;
import org.netbeans.api.visual.anchor.PointShape;
import org.netbeans.api.visual.graph.GraphScene;
import org.netbeans.api.visual.router.Router;
import org.netbeans.api.visual.router.RouterFactory;
import org.netbeans.api.visual.widget.ConnectionWidget;
import org.netbeans.api.visual.widget.LayerWidget;
import org.netbeans.api.visual.widget.Widget;
import org.netbeans.api.visual.widget.general.IconNodeWidget;
import org.openide.util.ImageUtilities;
import problema.viajero.Punto;

/**
 *
 * @author John Arevalo
 */
public class GrafoViajeroScene extends GraphScene<Punto, Arco> {

    private static final Image ICONO = ImageUtilities.loadImage("test/resources/node.png");
    private WidgetAction accionMover = ActionFactory.createMoveAction();
    private WidgetAction selectAction = ActionFactory.createSelectAction(new PuntoSelectProvider());
    private LayerWidget disenoPrincipal;
    private LayerWidget disenoConexiones;
    private Router router = RouterFactory.createFreeRouter();

    public GrafoViajeroScene() {
        disenoPrincipal = new LayerWidget(this);
        disenoConexiones = new LayerWidget(this);
        addChild(disenoPrincipal);
        addChild(disenoConexiones);
        initGrids();
    }

    @Override
    protected Widget attachNodeWidget(Punto punto) {
        IconNodeWidget nodo = new IconNodeWidget(this);
        nodo.setToolTipText("(" + punto.x + "," + punto.y + ")");
        nodo.setLabel(punto.getNombre());
        nodo.setImage(ICONO);
        nodo.getActions().addAction(accionMover);
        nodo.getActions().addAction(selectAction);
        disenoPrincipal.addChild(nodo);
        return nodo;
    }

    @Override
    protected Widget attachEdgeWidget(Arco arco) {
        ConnectionWidget conexion = new ConnectionWidget(this);
        conexion.setRouter(router);
        conexion.setToolTipText(String.valueOf(arco.getCosto()));
        conexion.setTargetAnchorShape(AnchorShape.TRIANGLE_FILLED);
        conexion.setControlPointShape(PointShape.SQUARE_FILLED_BIG);
        conexion.setEndPointShape(PointShape.SQUARE_FILLED_BIG);
        disenoConexiones.addChild(conexion);
        conexion.getActions().addAction(createSelectAction());
        return conexion;
    }

    @Override
    protected void attachEdgeSourceAnchor(Arco arco, Punto antiguoOrigen, Punto origen) {
        ConnectionWidget conexion = (ConnectionWidget) findWidget(arco);
        Widget widgetOrigen = findWidget(origen);
        conexion.setSourceAnchor(widgetOrigen != null
                ? AnchorFactory.createFreeRectangularAnchor(widgetOrigen, true) : null);

    }

    @Override
    protected void attachEdgeTargetAnchor(Arco arco, Punto antiguoDestino, Punto destino) {
        ConnectionWidget conexion = (ConnectionWidget) findWidget(arco);
        Widget widgetDestino = findWidget(destino);
        conexion.setTargetAnchor(widgetDestino != null
                ? AnchorFactory.createFreeRectangularAnchor(widgetDestino, true) : null);
    }

    public void initGrids() {
        Image sourceImage = ImageUtilities.loadImage("test/resources/paper_grid17.png"); // NOI18N
        int width = sourceImage.getWidth(null);
        int height = sourceImage.getHeight(null);
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.drawImage(sourceImage, 0, 0, null);
        graphics.dispose();
        TexturePaint background = new TexturePaint(image, new Rectangle(0, 0, width, height));
        setBackground(background);
        repaint();
        revalidate(false);
        validate();
    }

    class PuntoSelectProvider implements SelectProvider {

        public boolean isAimingAllowed(Widget arg0, Point arg1, boolean arg2) {
            return true;
        }

        public boolean isSelectionAllowed(Widget arg0, Point arg1, boolean arg2) {
            return true;
        }

        public void select(Widget widget, Point point, boolean invertSelection) {
            Object object = findObject(widget);

            if (object != null) {
                userSelectionSuggested(Collections.singleton(object), invertSelection);
            }
        }
    }
}
