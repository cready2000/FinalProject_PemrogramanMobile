package com.cready.finalproject.ui.budaya

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cready.finalproject.R
import kotlinx.android.synthetic.main.budaya_list_item.*

class BudayaFragment : Fragment() {

    private lateinit var BudayaViewModel: BudayaViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.budaya_fragment, container, false)
        val testData = createBudayaData()
        root.findViewById<RecyclerView>(R.id.BudayaRV).layoutManager = LinearLayoutManager(context)
        root.findViewById<RecyclerView>(R.id.BudayaRV).setHasFixedSize(true)
        root.findViewById<RecyclerView>(R.id.BudayaRV).adapter = BudayaAdapter(testData, {  BudayaItem: BudayaData -> BudayaItemClicked(BudayaItem)})
        return root
    }

    private fun BudayaItemClicked(BudayaData: BudayaData) {
        val showDetailActivity = Intent(context, BudayaDetailActivity::class.java)
        showDetailActivity.putExtra(Intent.EXTRA_SPLIT_NAME, BudayaData.BudayaPhoto.toString())
        showDetailActivity.putExtra(Intent.EXTRA_COMPONENT_NAME, BudayaData.BudayaNama.toString())
        showDetailActivity.putExtra(Intent.EXTRA_EXCLUDE_COMPONENTS, BudayaData.BudayaDeskripsi.toString())
        showDetailActivity.putExtra(Intent.EXTRA_REFERRER_NAME, BudayaData.BudayaWebsite.toString())
        startActivity(showDetailActivity)
    }

    private fun createBudayaData() : List<BudayaData> {
        val partList = ArrayList<BudayaData>()
        partList.add(BudayaData(R.drawable.ludruk,
            "Ludruk",
            "Ludruk merupakan kesenian teater rakyat Jawa Timur yang berasal dari kalangan rakyat jelata. Di Surabaya, kesenian Ludruk masih tetap bertahan meski hanya dipentaskan oleh beberapa puluh pemain saja. Harga tiket menonton Ludruk sebenarnya cukup murah, Rp 2.500, tetapi jumlah penontonnya semakin lama semakin berkurang, rata-rata 10-15 orang saja pada setiap pementasan. Mendapatkan penghasilan yang rendah membuat para pemain mau tidak mau harus memiliki pekerjaan sampingan.",
            "https://www.indonesiakaya.com/jelajah-indonesia/detail/ludruk",
        ))
        partList.add(BudayaData(R.drawable.tariremo,
            "Tari Remo",
            "Tarian Remo atau Ngremo adalah jenis tarian yang bisa dilakukan oleh laki-laki dan wanita. Biasanya dipentaskan ketika acara penyambutan tamu agung dan pejabat. Tari Remo mempunyai nilai sejarah dan filosofi pada setiap gerakannya. Oleh sebab itu, tarian ini menjadi salah satu jenis tari yang unik. Gerakan penari Remo diiringi oleh musik tradisional Gamelan.",
            "https://rimbakita.com/tari-remo/",
        ))
        partList.add(BudayaData(R.drawable.kidungan,
            "Kidungan",
            "Kidungan atau kidung mempunyai arti dalam bahasa Jawa adalah tembang dengan dialog Jawa Timur. Kata tembang berarti nyanyian jiwa atau pun ungkapan hati dan perasaan, yang diekspresikan dalam nyanyian sebagai senandung jiwa, karena perasaan tersebut biasanya timbul spontan dan dengan spontanitas tersebut maka keluarlah bahasa spontan yang menjadi alur suara dengan cengkok indah, hal ini merupakan ekspresi orisinil yang muncul dari lubuk hati yang paling dalam.\n\n"+
                          "Senandung jiwa tersebut dapat mengungkapkan perasaan sedang bahagia, sedih, gundah, cemas, riang atau rindu terhadap kekasih. Seseorang yang sedang melantunkan sebuah kidung tersebut sedang ngidung (bersyair), dimana ngidung tersebut menggunakan bahasa khas Jawa timur yang menggelitik, unik, jenaka, guyonan (candaan), kadang kala berisi sindiran kepada pihak lain, baik secara halus maupun kasar dan terang- terangan.\n\n"+
                          "Mendengar kidungan tersebut pihak yang dikritik akhirnya tidak bisa marah tetapi bahkan tertawa karena cara menyampaikan kritikan tersebut dilakukan dengan jenaka. Oleh karena itu kidungan dianggap merupakan cara yang paling mujarab dalam melakukan kritik dan dapat memberikan motivasi baru bagi yang dikritik.",
            "https://www.dictio.id/t/apa-yang-dimaksud-dengan-kidungan/123659",
        ))
        partList.add(BudayaData(R.drawable.rek,
            "Panggilan Arek atau Rek",
            "Basa Arekan adalah sebuah dialek bahasa Jawa yang dituturkan di Surabaya dan sekitarnya. Dialek ini berkembang dan digunakan oleh sebagian masyarakat Surabaya dan sekitarnya. Orang Surabaya lebih sering menggunakan partikel rek sebagai ciri khas mereka. Partikel ini berasal dari kata arek, yang dalam dialek Surabaya menggantikan kata bocah (anak) dalam bahasa Jawa standar.",
            "https://id.wikipedia.org/wiki/Bahasa_Jawa_Arekan",
        ))
        partList.add(BudayaData(R.drawable.cakdanning,
            "Cak dan Ning",
            "Sapaan cak dan ning Surabaya itu bukan sekedar panggilan akrab untuk kakak laki-laki dan perempuan ala warga Surabaya atau yang biasa disapa Arek-arek Suroboyo itu, melainkan sudah kerap kali dilombakan. Dengan melalui syarat dan kriteria tertentu dipilihlah pasangan muda-mudi unggul Surabaya sebagai figur Cak dan Ning yang nantinya akan menjadi teladan bagi warga Surabaya.\n\n"+
                          "Penjaringan Cak dan Ning dijadikan festival tahunan oleh Pemerintah Kota (pemkot) Surabaya. Penganugerahan Cak dan Ning biasanya digelar setiap bulan Mei, bersamaan dengan hari jadi Kota Surabaya. Sebagai figur Cak dan Ning Surabaya dipilihlah sosok yang bukan saja bagus secara fisik yaitu tampan dan cantik melainkan juga menguasai banyak hal (pintar) seperti yang telah ditetapkan oleh panitia lomba termasuk di antaranya harus memiliki kepribadian dan ahlak yang terpuji.\n\n"+
                          "Setelah dipilih melalui seleksi yang sangat ketat maka figur Cak dan Ning itu nantinya akan menjadi duta Surabaya, khususnya sebagai duta pariwisata dan budaya di forum regional maupun internasional.",
            "https://www.kompasiana.com/mawan.sidarta/5bd285e312ae946235650232/cak-dan-ning?page=all",
        ))
        return partList
    }
}