package com.max.mediaselector.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.max.mediaselector.MediaFile
import com.max.mediaselector.databinding.MediaSelectorFragmentPreviewImageBinding

class MediaImagePreviewFragment : Fragment {

    companion object {
        fun getInstance(mediaFile: MediaFile): MediaImagePreviewFragment {
            return MediaImagePreviewFragment(mediaFile)
        }
    }

    constructor()

    private constructor(mediaFile: MediaFile) {
        this.mediaFile = mediaFile
    }

    private val binding: MediaSelectorFragmentPreviewImageBinding by lazy {
        MediaSelectorFragmentPreviewImageBinding.inflate(layoutInflater)
    }

    private var mediaFile: MediaFile? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        if (mediaFile == null) {
            parentFragmentManager.popBackStack()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Glide.with(requireActivity())
            .load(mediaFile?.path)
            .thumbnail(0.1f)
            .into(binding.imageView)

    }

}