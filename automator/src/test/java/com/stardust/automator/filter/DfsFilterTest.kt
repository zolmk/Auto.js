package com.stardust.automator.filter

import com.stardust.automator.test.TestUiObject
import com.stardust.automator.UiObject

import org.junit.Test
import java.util.Random

import org.junit.Assert.*

/**
 * Created by Stardust on 2017/5/5.
 */
class DfsFilterTest {

    private class RandomDfsFilter : DfsFilter() {

        private val mRandom = Random()

        override fun isIncluded(nodeInfo: UiObject): Boolean {
            return mRandom.nextBoolean()
        }
    }

    @Test
    @Throws(Exception::class)
    fun filter() {
        val filter = RandomDfsFilter()
        val root = TestUiObject(10)
        val list = filter.filter(root)
        for (uiObject in list) {
            if (root !== uiObject)
                uiObject.recycle()
        }
        println(TestUiObject.max)
        assertEquals(1, TestUiObject.count.toLong())
    }

}