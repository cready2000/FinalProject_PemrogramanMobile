package com.cready.finalproject.ui.kuliner

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cready.finalproject.R

class KulinerFragment : Fragment() {

    private lateinit var KulinerViewModel: KulinerViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.kuliner_fragment, container, false)
        val testData = createKulinerData()
        root.findViewById<RecyclerView>(R.id.KulinerRV).layoutManager = LinearLayoutManager(context)
        root.findViewById<RecyclerView>(R.id.KulinerRV).setHasFixedSize(true)
        root.findViewById<RecyclerView>(R.id.KulinerRV).adapter = KulinerAdapter(testData, { KulinerItem: KulinerData ->KulinerItemClicked(KulinerItem)})
        return root
    }

    private fun KulinerItemClicked(KulinerData: KulinerData) {
        val showDetailActivity = Intent(context, KulinerDetailActivity::class.java)
        showDetailActivity.putExtra(Intent.EXTRA_SPLIT_NAME, KulinerData.KulinerPhoto.toString())
        showDetailActivity.putExtra(Intent.EXTRA_COMPONENT_NAME, KulinerData.KulinerNama.toString())
        showDetailActivity.putExtra(Intent.EXTRA_INSTALLER_PACKAGE_NAME, KulinerData.KulinerHarga.toString())
        showDetailActivity.putExtra(Intent.EXTRA_EXCLUDE_COMPONENTS, KulinerData.KulinerDeskripsi.toString())
        showDetailActivity.putExtra(Intent.EXTRA_REFERRER_NAME, KulinerData.KulinerWebsite.toString())
        showDetailActivity.putExtra(Intent.EXTRA_REFERRER, KulinerData.KulinerMapLat.toString())
        showDetailActivity.putExtra(Intent.EXTRA_BCC, KulinerData.KulinerMapLong.toString())
        startActivity(showDetailActivity)
    }


    private fun createKulinerData() : List<KulinerData> {
        val partList = ArrayList<KulinerData>()
        partList.add(KulinerData(R.drawable.sate,
            "Sate Klopo",
            "Mulai dari Rp 17.000 sampai Rp 18.000/porsi",
            "Sate klopo jadi kuliner wajib saat berkunjung ke Surabaya. Dibanding sate lain, sate klopo unik karena menggunakan kelapa atau klopo dalam pembuatannya. Tusukan daging sapi atau ayam dibaluri bumbu kelapa parut gurih saat dibakar. Pelengkapnya berupa serundeng yang juga terbuat dari kelapa.",
            "https://cookpad.com/id/resep/233795-sate-kloposate-kelapa",
            "-7.2601075",
            "112.7442245"
        ))
        partList.add(KulinerData(R.drawable.segosambel,
            "Sego Sambel",
            "Mulai dari Rp 15.000/porsi",
            "Sego sambel menjadi salah satu makanan khas Surabaya, Jawa Timur yang memiliki cita rasa pedasnya. Makanan yang terdiri dari nasi, cabai, dan berbagai lauk pauk.\n",
            "https://cookpad.com/id/resep/8511671-sego-sambal-panggang-suroboyo-an?via=search&search_term=sego%20sambal",
            "-7.3013194",
            "112.7380367"
        ))
        partList.add(KulinerData(R.drawable.lontongbalap,
            "Lontong Balap",
            "Mulai dari Rp 10.000/porsi",
            "Pecinta kuliner pasti tahu Surabaya memiliki lontong khas yang disebut lontong balap. Nama ini terbilang unik, karena lontong balap bukanlah nama merek melainkan nama dari hidangan itu sendiri.\n\n"+
                          "Lontong balap adalah sajian lontong berkuah dengan isian tauge, tahu, dan lento (kacang yang dimasak dengan cara khusus). Bagi yang suka rasa pedas dapat menambahkan sambal petis yang merupakan ciri khas lontong balap.",
            "https://cookpad.com/id/resep/14178257-lontong-balap-suroboyo?via=search&search_term=lontong%20balap%20surabaya",
            "-7.2646955",
            "112.7548971"
        ))
        partList.add(KulinerData(R.drawable.rujakcingur,
            "Rujak Cingur",
            "Mulai dari Rp 45.000/porsi",
            "Rujak Cingur adalah salah satu makanan tradisional yang terbuat dari campuran bahan seperti mentimun, cingur, kangkung, nanas dan lain–lain. Makanan satu ini sangat kaya akan campuran bahan, karena di dalamnya tedapat beberapa sayuran, buah–buahan, dan bahan lainnya. Rujak Cingur ini merupakan salah satu makanan tradisional yang sangat terkenal di Jawa Timur, terutama daerah Surabaya.",
            "https://cookpad.com/id/resep/14292807-rujak-cingur?via=search&search_term=rujak%20cingur",
            "-7.255378",
            "112.7402085"
        ))
        partList.add(KulinerData(R.drawable.tahucampur,
            "Tahu Campur",
            "Mulai dari Rp 20.000/porsi",
            "Tahu campur namanya, kuliner khas Jawa Timur ini menjadi salah satu makanan yang paling diburu para pecinta kuliner ketika berada di kawasan Surabaya dan sekitarnya. Memiliki rasa yang enak dengan sedikit nuansa bumbu petis di dalamnya.\n\n"+
                          "Tahu campur terbuat dari bahan-bahan seperti, daging sapi kenyal, tahu goreng, taoge, selada air, mie kuning. Semua bahan-bahan ini dipotong-potong kemudian disiram kuah yang terbuat dari aneka bumbu-bumbu yang sudah dicampur dengan petis, bumbu masakan khas Surabaya. Untuk menambah rasa tahu campur lebih enak tambahkan sambal serta kerupuk udang. Taburan bawang goreng menjadi penambah selera saat kuliner ini disajikan.",
            "https://cookpad.com/id/resep/14172910-tahu-campur?via=search&search_term=tahu%20campur",
            "-7.2592393",
            "112.7571132"
        ))
        partList.add(KulinerData(R.drawable.tahutek,
            "Tahu Tek",
            "Mulai dari Rp 11.000 sampai Rp 13.000/porsi",
            "Tahu tek adalah makanan yang pada dasarnya berisi tahu setengah matang dengan siraman saus kacang. Untuk lebih lengkap, tahu tek berisi tahu setengah matang, kentang goreng, lontong yang disiram dengan saus kacang. Tak lupa untuk tambahan ada yang ditambah dengan kecambah pendek dan yang paling penting kerupuk. Walaupun saus kacangnya terlihat sama dengan saus kacang rujak tapi rasanya berbeda lho. Saus kacang tahu tek lebih sederhana dengan campuran kacang goreng, petis, bawang goreng dan air matang.",
            "https://cookpad.com/id/resep/14189134-tahu-tek?via=search&search_term=tahu%20tek",
            "-7.2667807",
            "112.7680509"
        ))
        partList.add(KulinerData(R.drawable.rawonsetan,
            "Rawon Setan",
            "Mulai dari Rp 12.000 sampai Rp 30.000/porsi",
            "Surabaya adalah salah satu kiblat wisata dengan sejuta makanan khasnya, salah satu makanan yang paling terkenal di kota ini adalah rawon, orang Surabaya sangat menggemari salah satu makanan khas jawa timur ini bukan orang Surabaya kalau belum mencicipi rawon. Banyak sekali jenis rawon yang dijumpai di kota atlas ini namun yang paling hits dan banyak diminati serta di tunggu-tunggu yaitu Rawon Setan Surabaya.\n\n"+
                          "Makanan dengan kuah hitam kental ini sanggup membuat semua orang mabuk kepayang dengan bumbu khasnya yang biasa dicampur keluwak yang membuat kuahnya hitam pekat dan tentunya bumbu rahasia tergantung warung Rawon Setan Surabaya yang kamu jajaki. Jenis isi/lauk daging juga bervariasi ada yang berisi potongan daging, jeroan, telur, dan buntut sapi tergantung dari pengunjung yang memesan.",
            "https://cookpad.com/id/resep/13825108-rawon-setan?via=search&search_term=rawon%20setan",
            "-7.2591553",
            "112.7351921",
        ))
        partList.add(KulinerData(R.drawable.pecelsemanggi,
            "Pecel Semanggi",
            "Mulai dari Rp 10.000/porsi",
            "Kota Surabaya, selain dikenal sebagai Kota Pahlawan juga dikenal dengan kuliner khasnya yakni Pecel Semanggi. Seperti namanya, pecel semanggi terbuat dari daun semanggi yang dikukus dan disajikan dengan beberapa sayuran lainnya seperti kecambah. Pecel semanggi adalah salah satu jajanan tradisional dari Surabaya yang masih eksis di tengah perkembangan jaman.\n\n"+
                          "Pecel semanggi berbahan dasar daun semanggi muda dan sayuran lain seperti kecambah atau kangkung. Daun semanggi muda yang sudah dibersihkan kemudian dikukus dan disajikan dengan daun pisang yang dibentuk segitiga atau disebut pincuk. Daun semanggi kemudian dituangi bumbu pecel. Bumbu pecel semanggi berbeda dengan bumbu pecel pada umumnya. Bumbu pecel semanggi terbuat dari ketela rambat, kacang tanah, gula merah, bawang, garam dan cabai. Ketela rambat atau ubi memberikan tekstur yang berbeda sehingga hal tersebut yang membedakan antara bumbu pecel semanggi dengan bumbu pecel lainnya. Selain itu, pecel semanggi selalu disajikan dengan pasangannya, yakni kerupuk puli.",
            "https://cookpad.com/id/resep/1771583-pecel-semanggi-suroboyoan?via=search&search_term=pecel%20semanggi",
            "-7.3313973",
            "112.7807724",
        ))
        partList.add(KulinerData(R.drawable.sotoayam,
            "Soto Ayam Ambengan",
            "Mulai dari Rp 22.500/porsi",
            "Soto Ayam Ambengan adalah salah satu makanan khas kota Surabaya. Berbeda dengan Soto Ayam dari daerah lainnya di Indonesia, makanan khas Surabaya ini warna kuahnya lebih kuning pekat karena memakai kunir dalam pembuatannya. Soto Ayam Ambengan terdiri dari daging ayam (daging, jerohan, kulit, brutu), telur, nasi putih, bihun, kubis cacah dan kuah kaldu ayam. Biasanya para pecinta makanan ini kemudian mencampur makanannya dengan koya (bubuk yang terbuat dari parutan kelapa, tumbukan kerupuk udang, dan bawang putih), kerupuk, sambal, dan jeruk nipis. Ada pula yang kemudian masih menambahkan kecap manis atau kecap asin sesuai selera.",
            "https://cookpad.com/id/resep/999527-soto-ambengan-surabaya-bumbu-koya",
            "-7.3325917",
            "112.7854025",
        ))
        partList.add(KulinerData(R.drawable.eskrim,
            "Es Krim Zangrandi",
            "Mulai dari Rp 9.000",
            "Gerai es krim ini berdiri sejak tahun 1930 dengan nama Zangrandi. Nama ini diambil dari nama Roberto Zangrandi yang berasal dari Italia. Dengan tangan istrinya tercipta resep es krim yang menjadi salah satu pionir usaha es krim terkemuka di Surabaya. Lalu, pada tahun 1960 usaha ini dibeli oleh Aditanumulia, pengusaha winery. Ia memberikan sentuhan rasa baru khas Indonesia, yaitu rasa durian.",
            "https://cookpad.com/id/resep/13053769-durian-ice-cream?via=search&search_term=es%20krim%20durian",
            "-7.2634139",
            "112.7461219",
        ))
        return partList
    }
}