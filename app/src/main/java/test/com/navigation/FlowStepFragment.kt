package test.com.navigation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation

class FlowStepFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val flowStepNumber = arguments?.getInt("flowStepNumber")
        Log.d(TAG, "flowStepNumber = $flowStepNumber")
        return when(flowStepNumber){
            2 -> inflater.inflate(R.layout.flow_step_two_fragment, container, false)
            else -> inflater.inflate(R.layout.flow_step_one_fragment, container, false)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.next_button).setOnClickListener {
            //TODO using Navigation.createNavigateOnClickListener(action_id or destination_id)
            //Navigation.createNavigateOnClickListener(R.id.next_action, null).onClick(view)
            //Navigation.createNavigateOnClickListener(R.id.home_dest, null).onClick(view)
            //TODO using NavController.navigate(action_id or destination_id)
            Navigation.findNavController(view).navigate(R.id.next_action)
        }
    }

    companion object{
        private val TAG = FlowStepFragment::class.java.simpleName
    }
}