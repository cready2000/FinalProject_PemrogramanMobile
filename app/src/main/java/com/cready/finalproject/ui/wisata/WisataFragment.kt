package com.cready.finalproject.ui.wisata

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cready.finalproject.R

class WisataFragment : Fragment() {

    private lateinit var WisataViewModel: WisataViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.wisata_fragment, container, false)
        val testData = createWisataData()
        root.findViewById<RecyclerView>(R.id.wisataRV).layoutManager = LinearLayoutManager(context)
        root.findViewById<RecyclerView>(R.id.wisataRV).setHasFixedSize(true)
        root.findViewById<RecyclerView>(R.id.wisataRV).adapter = WisataAdapter(testData, { WisataItem: WisataData -> wisataItemClicked(WisataItem)})
        return root
    }

    private fun wisataItemClicked(WisataData: WisataData) {
        val showDetailActivity = Intent(context, WisataDetailActivity::class.java)
        showDetailActivity.putExtra(Intent.EXTRA_SPLIT_NAME, WisataData.WisataPhoto.toString())
        showDetailActivity.putExtra(Intent.EXTRA_COMPONENT_NAME, WisataData.WisataNama.toString())
        showDetailActivity.putExtra(Intent.EXTRA_INSTALLER_PACKAGE_NAME, WisataData.WisataDeskripsi.toString())
        showDetailActivity.putExtra(Intent.EXTRA_REFERRER_NAME, WisataData.WisataWebsite.toString())
        showDetailActivity.putExtra(Intent.EXTRA_REFERRER, WisataData.WisataMapLat.toString())
        showDetailActivity.putExtra(Intent.EXTRA_BCC, WisataData.WisataMapLong.toString())
        startActivity(showDetailActivity)
    }

    private fun createWisataData() : List<WisataData> {
        val partList = ArrayList<WisataData>()
        partList.add(WisataData(R.drawable.mangrove,
            "Ekowisata Mangrove",
            "Surabaya tidak hanya kaya wisata sejarah dengan bangunan sejarahnya. Akan tetapi, wisata alam di Surabaya, Jawa Timur juga patut diperhitungkan. Salah satunya ekowisata mangrove, Wonorejo, Surabaya, Jawa Timur. Selain tentu ada mangrove dengan luas lahan lebih dari 800 hektar, di kawasan ini terdapat juga 83 spesies burung eksotik dan langka seperti bambangan kuning, cangak merah, perkutut Jawa, dan punai gading. Mangrove atau bakau adalah spesies tanaman yang hidup di antara batas pasang dan surut sebuah kawasan pesisir. Di pantai timur Surabaya ini, lebih dari setengah jenis bakau yang ada di Indonesia tumbuh subur di sana.",
            "https://travelingyuk.com/ekowisata-mangrove-wonorejo/133855",
            "-7.3086482",
            "112.8216622"
        ))
        partList.add(WisataData(R.drawable.airmancur,
            "Air Mancur Menari",
            "Traveler yang datang ke Surabaya tak hanya melihat ikon patung Sura dan Baya saja, terdapat pemandangan yang tak kalah menarik yaitu Air Mancur Menari Surabaya. Tempat wisata ini menjadi favorit orang dewasa bahkan anak-anak. Traveler bisa menyaksikan air mancur dengan lampu led berwarna-warni, lebih kerennya lagi ada tambahan musik yang semakin membuat pertunjukan Dancing and Musical Fountain semakin seru. Obyek wisata satu ini menjadi rekomendasi masuk ke daftar liburan saat ke Surabaya.",
            "https://gotripina.com/blog/air-mancur-menari-surabaya",
            "-7.2356933",
            "112.7955234"
        ))
        partList.add(WisataData(R.drawable.monkasel,
            "Monumen Kapal Selam",
            "Indonesia terkenal sebagai negara dengan wilayah maritim yang luas. Peninggalannya pun masih dapat dinikmati hingga saat ini, seperti adanya Monumen Kapal Selam Surabaya. Yaitu sebuah kapal yang berada di darat, dimaksudkan sebagai bangunan museum.\n\n"+
                          "Surabaya juga dikenal sebagai kota dengan kekuatan maritim yang hebat. Sejak zaman dahulu kala, kota ini telah menjadi pusat perdagangan dunia. Dan Monumen Kapal Selam (Monkasel) ini menjadi bukti Surabaya memiliki kekuatan maritim yang hebat.",
            "https://travelspromo.com/htm-wisata/monumen-kapal-selam-surabaya/",
            "-7.2654304",
            "112.7503052"
        ))
        partList.add(WisataData(R.drawable.demata,
            "De Mata Trick Eye Museum",
            "De Mata Trick Eye Museum merupakan suatu museum seni ilusi optical atau museum 3D yang berada di kota Surabaya. Museum satu ini hingga sekarang tercatat mempunyai banyak seni 3D dengan berbagai tema mulai dari olahraga, alam, binatang, angka, romantis, pahlawan, sirkus, ornamen dan yang lainnya. De Mata Museum ini juga menempatkan lukisan 3D dengan mengusung konsep labirin sehingga akan membuat setiap wisatawan tidak akan mudah merasa bosan.",
            "https://www.hargatiket.net/de-mata-trick-eye-museum-surabaya/",
            "-7.2943024",
            "112.7296608"
        ))
        partList.add(WisataData(R.drawable.hutanbambu,
            "Hutan Bambu Keputih",
            "Surabaya menjadi kota metropolitan kedua setelah Jakarta. Kepadatan penduduk Surabaya pun cukup tinggi, dan karena terletak di pesisir, suhu kota terasa panas. Meski begitu, masih ada tempat sejuk, teduh, dan asri di tengah Kota Surabaya. Ialah Hutan Bambu Surabaya, tepatnya berada di Keputih.\n\n"+
                          "Mendengar nama “Hutan Bambu”, mungkin yang terlintas adalah hutan di pedesaan. Tapi jangan salah, di tengah kota pun dapat terwujud tempat asri seperti ini. Suasananya yang asri membuat pengunjung berbondong-bondong datang ke lokasi ini. Dan sekarang, taman rekreasi ini tengah menjadi favorit pengunjung menghabiskan waktu luang.",
            "https://travelspromo.com/htm-wisata/hutan-bambu-surabaya/",
            "-7.2941909",
            "112.8017238"
        ))
        partList.add(WisataData(R.drawable.kenpark,
            "Kenjeran Park",
            "Ada yang pernah pergi ke Surabaya? Kota metropolitan terbesar ke 2 setelah Jakarta itu mulai berbenah di bidang pariwisata. Dahulu, saat saya pertama kali pergi ke Surabaya, saya bingung apa yang harus saya kunjungi di kota Pahlawan ini. Apakah hanya museum kapal pesiar yang berada di dekat Stasiun Gubeng saja. Karena, Surabaya memang kurang ramah untuk sebuah kawasan wisata.\n\n"+
                          "Tetapi, persepsi itu berubah seketika. Surabaya tidak hanya mempunyai Jembatan Suramadu yang konon katanya saat malam hari jembatan yang menghubungkan pulau jawa dengan pulau Madura ini menampakkan keindahannya yang tidak akan terlihat saat siang hari. Nah, kawasan yang saat ini sedang diperbincangkan banyak orang tersebut adalah Kenjeran Park.",
            "https://www.nativeindonesia.com/kenjeran-park-surabaya/",
            "-7.2522964",
            "112.7966952"
        ))
        partList.add(WisataData(R.drawable.northquay,
            "Surabaya North Quay",
            "Surabaya menjadi kota besar yang sering menjadi tempat tujuan wisata. Berbagai tempat belanja dari tradisional hingga modern ada di Ibukota Jawa Timur ini. Namun, apakah tidak bosan wisata belanja saja di Surabaya? Jika bosan, datanglah ke Surabaya North Quay, objek wisata baru di Surabaya.\n\n"+
                          "Surabaya North Quay sebenarnya adalah terminal bagi kapal pesiar mewah yang bersandar. Namun, tempat ini sengaja dibenahi supaya dapat menjadi tempat wisata bagi warga Surabaya dan sekitarnya. Bahkan, tak sedikit yang berasal dari luar daerah yang penasaran ingin menikmati pemandangan menakjubkan. Lautan lepas dengan kapal pesiar mewah yang bersandar di terminal ini, menjadi daya tarik utamanya.",
            "https://travelspromo.com/htm-wisata/surabaya-north-quay/",
            "-7.1968193",
            "112.7324578"
        ))
        partList.add(WisataData(R.drawable.kebunbibit,
            "Kebun Bibit",
            "Meskipun namanya kebun bibit, namun kawasan ini rasanya lebih cocok disebut sebagai taman. Kawasan Kebun Bibit Wonorejo ini terbagi menjadi 2 bagian, yaitu Taman Aktif dan Taman Pasif yang total keduanya mempunyai luas sebesar 5.9 hektare.",
            "https://www.nativeindonesia.com/menariknya-kebun-bibit-wonorejo/",
            "-7.3123655",
            "112.7889021"
        ))
        partList.add(WisataData(R.drawable.kbs,
            "Kebun Binatang Surabaya",
            "Kebun Binatang Surabaya (KBS) adalah salah satu kebun binatang yang populer di Indonesia dan terletak di Surabaya. KBS merupakan kebun binatang yang pernah terlengkap se-Asia Tenggara, di dalamnya terdapat lebih dari 211 spesies satwa yang berbeda yang terdiri lebih dari 2.236 binatang. Termasuk di dalamnya satwa langka Indonesia maupun dunia terdiri dari Mamalia, Aves, Reptilia, dan Pisces.",
            "https://www.surabayazoo.co.id/",
            "-7.2959546",
            "112.7366094"
        ))
        partList.add(WisataData(R.drawable.ciputra,
            "Ciputra Waterpark",
            "Bermain air di waterpark memang bisa menjadi alternatif rekreasi kaum urban di berbagai kota besar. Tidak hanya Jakarta, Surabaya sebagai salah satu kota metropolis di Indonesia juga sudah mulai bergeliat membangun tempat rekreasi keluarga.\n\n"+
                          "Salah satunya waterpark yang bisa menjadi tujuan wisata keluarga adalah Ciputra Waterpark Surabaya. Berlokasi di Waterpark Boulevard, Citraland “The Singapore of Surabaya”, Surabaya, waterpark yang berdiri di areal seluas 5 hektar  menawarkan beragam aktivitas dan atraksi menarik. Tidak salah jika waterpark yang satu ini mengklaim sebagai water attraction terbesar Indonesia.",
            "http://www.ciputrawaterparksurabaya.com/new2/",
            "-7.2861707",
            "112.6333338"
        ))
        partList.add(WisataData(R.drawable.suroboyocarnival,
            "Surabaya Carnival Night Market",
            "Suroboyo Carnival Night Market bisa menjadi alternatif tempat rekreasi keluarga ketika berlibur di Surabaya. Mengusung konsep Carnival Park yang khusus beroperasi di malam hari. Mata kita akan dimanjakan dengan desain lampu-lampu yang sangat cantik. Dengan harga tiket Suroboyo Carnival yang masih terjangkau dijamin tidak akan kecewa.",
            "https://travelspromo.com/htm-wisata/suroboyo-carnival-atraksi-wahana-tiket-masuk/",
            "-7.345024",
            "112.732903"
        ))
        partList.add(WisataData(R.drawable.museum10nopember,
            "Museum Sepuluh Nopember",
            "Surabaya yang dijuluki Kota Pahlawan mempunyai banyak sekali gedung yang berhubungan dengan sejarah di dalamnya. Salah satunya adalah Museum Sepuluh Nopember. Sesuai namanya, museum ini berisi koleksi dan bukti sejarah peristiwa 10 Nopember 1945.",
            "https://travelingyuk.com/museum-sepuluh-nopember/262664",
            "-7.2454369",
            "112.7378985"
        ))
        partList.add(WisataData(R.drawable.museumkesehatan,
            "Museum Kesehatan Dr. Adhyatma",
            "Di Surabaya, Teman Traveler tidak hanya menemukan tempat sejarah yang berkaitan dengan kemerdekaan. Tapi ada juga wisata sejarah yang berhubungan dengan kesehatan. Yakni Museum Kesehatan Dr Adhyatma , MPH yang didirikan sejak tahun 1990.",
            "https://travelingyuk.com/unikologi-coffee/285227/",
            "-7.240328",
            "112.731431"
        ))
        partList.add(WisataData(R.drawable.kampungbulak,
            "Kampung Bulak",
            "Apa sih yang terpikirkan jika mendengar kata “kampung”? Mungkin akan sering muncul penggambaran kalau kampung itu kumuh, jorok, dan terpencil. Kampung Bulak Surabaya ini awalnya adalah kampung yang biasa saja. Tetapi sejak pemerintah kota Surabaya, Tri Rismaharini, merubah kampung ini menjadi warna-warni, banyak pengunjung yang mampir ke kampung ini untuk memburu foto yang bisa di-upload di instagram.",
            "https://sewabussurabaya.com/kampung-bulak-surabaya/",
            "-7.236774",
            "112.7896966"
        ))
        partList.add(WisataData(R.drawable.tugupahlawan,
            "Tugu Pahlawan",
            "Surabaya, sebuah kota di ujung timur Pulau Jawa ini dibangun oleh semangat para pejuang kemerdekaan. Para pejuang tersebut dengan gagah berani mempertahankan tanah leluhur mereka. Salah satu peristiwa bersejarah yang akan selalu dikenang adalah Peristiwa 10 November 1945. Peristiwa ini pun dinobatkan sebagai salah satu peristiwa bersejarah terbesar setelah proklamasi kemerdekaan.\n\n"+
                          "Sebagai cara untuk mengenang jasa para pahlawan yang mendedikasikan perjuangan mereka pada peristiwa 10 November 1945 tersebut, maka dibangunlah sebuah tugu megah di tengah Kota Surabaya. Tugu ini kemudian dinamakan Tugu Pahlawan.",
            "https://www.batiqa.com/id/hotels/surabaya/read-article/tugu-pahlawan-surabaya-another-way-to-enjoy-history",
            "-7.2461748",
            "112.7377652"
        ))
        partList.add(WisataData(R.drawable.tamanbungkul,
            "Taman Bungkul",
            "Surabaya menjadi kota metropolitan kedua setelah Jakarta. Menyandang gelar tersebut, tak heran jika citra mahal secara otomatis tersemat untuk Surabaya. Meski begitu, untuk berlibur murah di Surabaya bukanlah isapan jempol belaka. Bahkan, objek wisata gratis dan indah pun tersedia, salah satunya Taman Bungkul Surabaya.\n\n"+
                          "Taman rekreasi ini menjadi taman kebanggaan Surabaya dan warga Jawa Timur. Apalagi, taman ini telah menyandang gelar terbaik se-Asia Tenggara. Sempat terjadi, Walikota Surabaya, Ibu Risma, yang kala itu marah karena area taman yang dirusak. Tak heran, karena pembuatan taman ini menghabiskan anggaran miliaran rupiah.",
            "https://travelspromo.com/htm-wisata/taman-bungkul-surabaya/",
            "-7.2913468",
            "112.7398218"
        ))
        partList.add(WisataData(R.drawable.tamanmundu,
            "Taman Mundu",
            "Taman Mundu merupakan salah satu taman atau ruang terbuka hijau terutama bagi warga kota Surabaya, taman ini lebih tepatnya berada di Jl. Tambaksari atau berada di seberang Stadion Gelora Sepuluh November Tambaksari Surabaya. Taman Mundu dibangun menempati area seluas 4.800 meter persegi dan pembangunannya diresmikan pada 10 Juli 2010. Taman yang cantik ini mempunyai berbagai fasilitas yang bisa dinikmati dan digunakan oleh warga Surabaya atau siapapun yang mengunjungi taman ini, diantarnya fasilitas arena bermain bagi anak-anak, jogging track, air mancur yang indah, lampu-lampu hias, kolam air, toilet yang mewah dan dua pohon Mundu yang besar sebagai icon Taman Mundu. Tidak hanya itu di Taman Mundu juga tersedia fasilitas air kran siap minum yang merupakan fasilitas yang disediakan oleh Perusahaan Air Minum Daerah (PDAM) Surabaya.",
            "http://www.wisesatravel.com/2015/12/taman-mundu-taman-keren-kota-surabaya.html",
            "-7.2516046",
            "112.7545983"
        ))
        partList.add(WisataData(R.drawable.tamanpersahabatan,
            "Taman Persahabatan",
            "Area seluas 2.259 m2, eks SPBU Sulawesi, kini telah disulap menjadi taman yang indah. Taman persahabatan ini pun menambah deretan taman rekreasi yang nyaman bagi keluarga di Surabaya. Warga kota kerap memanfaatkan tempat ini untuk wisata bersama keluarga dan anak-anaknya.",
            "https://fasilitasumumsby.wordpress.com/taman/taman-persahabatan/",
            "-7.2832455",
            "112.7360773"
        ))
        partList.add(WisataData(R.drawable.jembatanmerah,
            "Jembatan Merah",
            "Surabaya, Jawa Timur memiliki segudang saksi bisu perjuangan para pahlawan. Salah satunya Jembatan Merah, di Jalan Kembang, Surabaya, Jawa Timur. Kalau dilihat sekilas, jembatan ini sepertinya biasa saja, hanya jembatan yang berwarna merah. Namun, sebenarnya jembatan tersebut menyimpan banyak sekali sejarah. Pada masa penjajahan, jembatan merah dianggap sebagai lokasi yang penting, karena merupakan satu-satunya akses transportasi perdagangan yang melewati Kalimas dan Gedung Residensi Surabaya.",
            "https://surabaya.liputan6.com/read/4008723/jembatan-merah-surabaya-sungguh-gagah",
            "-7.2367447",
            "112.7383009"
        ))
        partList.add(WisataData(R.drawable.balaikota,
            "Balai Kota Surabaya",
            "Gedung peninggalan penjajah Belanda yang saat ini dijadikan Balai Kota Surabaya. Banyak kegiatan masyarakat diselenggarakan di sini. Pengunjung boleh masuk ke dalamnya untuk mengetahui info tentang asal usul kota Surabaya. Uniknya pengunjung juga bisa menyaksikan salah satu bunker yang ada di bawah gedungnya.",
            "http://situsbudaya.id/sejarah-gedung-balai-kota-surabaya/",
            "-7.2592948",
            "112.7470512"
        ))
        return partList
    }
}