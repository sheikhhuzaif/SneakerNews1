package com.mikepenz.materialdrawer.model

import android.view.View
import android.widget.CompoundButton
import android.widget.ToggleButton
import androidx.annotation.LayoutRes
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.R
import com.mikepenz.materialdrawer.interfaces.OnCheckedChangeListener
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem

/**
 * Created by mikepenz on 03.02.15.
 */
open class AbstractToggleableDrawerItem<Item : AbstractToggleableDrawerItem<Item>> : BaseDescribeableDrawerItem<Item, AbstractToggleableDrawerItem.ViewHolder>() {

    var isToggleEnabled = true
    var isChecked = false
    var onCheckedChangeListener: OnCheckedChangeListener? = null

    override val type: Int
        get() = R.id.material_drawer_item_primary_toggle

    override val layoutRes: Int
        @LayoutRes
        get() = R.layout.material_drawer_item_toggle

    private val checkedChangeListener = object : CompoundButton.OnCheckedChangeListener {
        override fun onCheckedChanged(buttonView: CompoundButton, ic: Boolean) {
            if (isEnabled) {
                isChecked = ic
                onCheckedChangeListener?.onCheckedChanged(this@AbstractToggleableDrawerItem, buttonView, ic)
            } else {
                buttonView.setOnCheckedChangeListener(null)
                buttonView.isChecked = !ic
                buttonView.setOnCheckedChangeListener(this)
            }
        }
    }

    fun withChecked(checked: Boolean): Item {
        this.isChecked = checked
        return this as Item
    }

    fun withToggleEnabled(toggleEnabled: Boolean): Item {
        this.isToggleEnabled = toggleEnabled
        return this as Item
    }

    fun withOnCheckedChangeListener(onCheckedChangeListener: OnCheckedChangeListener): Item {
        this.onCheckedChangeListener = onCheckedChangeListener
        return this as Item
    }

    override fun bindView(holder: ViewHolder, payloads: MutableList<Any>) {
        super.bindView(holder, payloads)

        //bind the basic view parts
        bindViewHelper(holder)

        //handle the toggle
        holder.toggle.setOnCheckedChangeListener(null)
        holder.toggle.isChecked = isChecked
        holder.toggle.setOnCheckedChangeListener(checkedChangeListener)
        holder.toggle.isEnabled = isToggleEnabled

        //add a onDrawerItemClickListener here to be able to check / uncheck if the drawerItem can't be selected
        withOnDrawerItemClickListener(object : Drawer.OnDrawerItemClickListener {
            override fun onItemClick(view: View?, position: Int, drawerItem: IDrawerItem<*>): Boolean {
                if (!isSelectable) {
                    isChecked = !isChecked
                    holder.toggle.isChecked = isChecked
                }

                return false
            }
        })

        //call the onPostBindView method to trigger post bind view actions (like the listener to modify the item if required)
        onPostBindView(this, holder.itemView)
    }

    override fun getViewHolder(v: View): ViewHolder {
        return ViewHolder(v)
    }

    open class ViewHolder internal constructor(view: View) : BaseViewHolder(view) {
        internal val toggle: ToggleButton = view.findViewById<ToggleButton>(R.id.material_drawer_toggle)
    }
}
