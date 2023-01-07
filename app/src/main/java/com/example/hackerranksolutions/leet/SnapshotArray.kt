package com.example.hackerranksolutions.leet


internal class SnapshotArray(length: Int) {
    //map <Snap_id , Value> for each index (array of maps)
    var snapShotHistory: Array<HashMap<Int, Int?>?>

    //totalSnaps taken
    var totalSnaps = 0

    //map of delta updates made <index, value>
    var deltaUpdate: HashMap<Int, Int>
    fun set(index: Int, `val`: Int) {
        //add a delta update for this index, value pair
        deltaUpdate[index] = `val`
    }

    fun snap(): Int {
        //add the current mapping at each index, value pair
        for (key in deltaUpdate.keys) {
            val snapHistoryAtIndex = snapShotHistory[key]
            //add a snapshot of the <snapId, value> to the index updated
            snapHistoryAtIndex!![totalSnaps] = deltaUpdate[key]
        }

        //reset out delta update map
        deltaUpdate = HashMap()

        //incremement our total snaps and return the snap id
        totalSnaps++
        return totalSnaps - 1
    }

    fun get(index: Int, snap_id: Int): Int {
        //find the most recent update to that index from the snapId specified and before
        var snapId = snap_id
        while (snapId >= 0) {
            if (snapShotHistory[index]!!.containsKey(snapId)) return snapShotHistory[index]!![snapId]!!
            snapId--
        }

        //if there was never an update to that index, it will just be equal to 0
        return 0
    }

    init {
        //keep track of the delta updates made in each iteration
        deltaUpdate = HashMap()

        //initialize a snapshot history
        snapShotHistory = arrayOfNulls(length)
        for (i in 0 until length) {
            snapShotHistory[i] = HashMap()
        }
    }
}