package ql_obj_alg.user_interface.modules;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;

public class InvisibleGridLayout implements LayoutManager, java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	int hgap;
    int vgap;
    int rows;
    int cols;

    public InvisibleGridLayout() {
    this(1, 0, 0, 0);
    }

    public InvisibleGridLayout(int rows, int cols) {
    this(rows, cols, 0, 0);
    }

    public InvisibleGridLayout(int rows, int cols, int hgap, int vgap) {
    if ((rows == 0) && (cols == 0)) {
        throw new IllegalArgumentException("rows and cols cannot both be zero");
    }
    this.rows = rows;
    this.cols = cols;
    this.hgap = hgap;
    this.vgap = vgap;
    }

    public int getRows() {
    return rows;
    }

    public void setRows(int rows) {
    if ((rows == 0) && (this.cols == 0)) {
        throw new IllegalArgumentException("rows and cols cannot both be zero");
    }
    this.rows = rows;
    }

    public int getColumns() {
    return cols;
    }

    public void setColumns(int cols) {
    if ((cols == 0) && (this.rows == 0)) {
        throw new IllegalArgumentException("rows and cols cannot both be zero");
    }
    this.cols = cols;
    }

    public int getHgap() {
    return hgap;
    }

    public void setHgap(int hgap) {
    this.hgap = hgap;
    }

    public int getVgap() {
    return vgap;
    }

    public void setVgap(int vgap) {
    this.vgap = vgap;
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
      synchronized (parent.getTreeLock()) {
    Insets insets = parent.getInsets();
    int ncomponents = getVisibleComponents(parent);
    int nrows = rows;
    int ncols = cols;

    if (nrows > 0) {
        ncols = (ncomponents + nrows - 1) / nrows;
    } else {
        nrows = (ncomponents + ncols - 1) / ncols;
    }
    int w = 0;
    int h = 0;
    for (int i = 0 ; i < parent.getComponentCount(); i++) {
        Component comp = parent.getComponent(i);

        if (!comp.isVisible()) continue; // added

        Dimension d = comp.getPreferredSize();
        if (w < d.width) {
        w = d.width;
        }
        if (h < d.height) {
        h = d.height;
        }
    }

    Dimension d = new Dimension(insets.left + insets.right + ncols*w + (ncols-1)*hgap,
                 insets.top + insets.bottom + nrows*h + (nrows-1)*vgap);

    return d;
      }
    }

    public Dimension minimumLayoutSize(Container parent) {
      synchronized (parent.getTreeLock()) {
        Insets insets = parent.getInsets();
    int ncomponents = getVisibleComponents(parent);
    int nrows = rows;
    int ncols = cols;

    if (nrows > 0) {
        ncols = (ncomponents + nrows - 1) / nrows;
    } else {
        nrows = (ncomponents + ncols - 1) / ncols;
    }
    int w = 0;
    int h = 0;
    for (int i = 0 ; i < parent.getComponentCount(); i++) {
        Component comp = parent.getComponent(i);

        if (!comp.isVisible()) continue;

        Dimension d = comp.getMinimumSize();
        if (w < d.width) {
        w = d.width;
        }
        if (h < d.height) {
        h = d.height;
        }
    }

    Dimension d = new Dimension(insets.left + insets.right + ncols*w + (ncols-1)*hgap,
                 insets.top + insets.bottom + nrows*h + (nrows-1)*vgap);

    return d;
      }
    }

    public void layoutContainer(Container parent) {
      synchronized (parent.getTreeLock()) {
    Insets insets = parent.getInsets();
    int ncomponents = getVisibleComponents(parent);
    int nrows = rows;
    int ncols = cols;
    boolean ltr = parent.getComponentOrientation().isLeftToRight();

    if (ncomponents == 0) {
        return;
    }
    if (nrows > 0) {
        ncols = (ncomponents + nrows - 1) / nrows;
    } else {
        nrows = (ncomponents + ncols - 1) / ncols;
    }
    int w = parent.getSize().width - (insets.left + insets.right);
    int h = parent.getSize().height - (insets.top + insets.bottom);
    w = (w - (ncols - 1) * hgap) / ncols;
    h = (h - (nrows - 1) * vgap) / nrows;

        int i = 0;

        if (ltr)
        {
            for (int r = 0, y = insets.top ; r < nrows ; r++, y += h + vgap)
            {
                int c = 0;
                int x = insets.left;

                while (c < ncols)
                {
                    if (i >= parent.getComponentCount()) break;

                    Component component = parent.getComponent(i);

                    if (component.isVisible())
                    {
                        parent.getComponent(i).setBounds(x, y, w, h);
                        c++;
                        x += w + hgap;
                    }

                    i++;
                }
            }
        }

    }}

    private int getVisibleComponents(Container parent)
    {
        int visible = 0;

        for (Component c: parent.getComponents())
        {
            if (c.isVisible())
                visible++;
        }

        return visible;
    }

    public String toString() {
    return getClass().getName() + "[hgap=" + hgap + ",vgap=" + vgap +
                           ",rows=" + rows + ",cols=" + cols + "]";
    }

}