package hu.nooon.dobido.client.resource;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.TextResource;

public interface SiteClientBundle extends ClientBundle {

    public static final SiteClientBundle INSTANCE =  GWT.create(SiteClientBundle.class);

    @Source("hu/nooon/dobido/public/images/background/background.jpg")
    public ImageResource background();


    @Source("hu/nooon/dobido/public/images/home/band/bezs.jpg")
    public ImageResource home_band_bezs();
    @Source("hu/nooon/dobido/public/images/home/band/ervin.jpg")
    public ImageResource home_band_ervin();
    @Source("hu/nooon/dobido/public/images/home/band/racka.jpg")
    public ImageResource home_band_racka();
    @Source("hu/nooon/dobido/public/images/home/band/zadi.jpg")
    public ImageResource home_band_zadi();

    @Source("hu/nooon/dobido/public/images/home/gallery/IMG_7302-copy_01.jpg")
    public ImageResource home_gallery1();
    @Source("hu/nooon/dobido/public/images/home/gallery/IMG_7302-copy_02.jpg")
    public ImageResource home_gallery2();

    @Source("hu/nooon/dobido/public/images/home/music/IMG_7575-copy_01.jpg")
    public ImageResource home_music1();
    @Source("hu/nooon/dobido/public/images/home/music/IMG_7575-copy_02.jpg")
    public ImageResource home_music2();


    @Source("hu/nooon/dobido/public/images/home/news/IMG_7474-copy_01.jpg")
    public ImageResource home_news1();
    @Source("hu/nooon/dobido/public/images/home/news/IMG_7474-copy_02.jpg")
    public ImageResource home_news2();
    @Source("hu/nooon/dobido/public/images/home/news/IMG_7474-copy_03.jpg")
    public ImageResource home_news3();
    @Source("hu/nooon/dobido/public/images/home/news/IMG_7474-copy_04.jpg")
    public ImageResource home_news4();

    @Source("hu/nooon/dobido/public/images/home/tour_dates/IMG_7487-copy_01.jpg")
    public ImageResource home_tour1();
    @Source("hu/nooon/dobido/public/images/home/tour_dates/IMG_7487-copy_02.jpg")
    public ImageResource home_tour2();
    @Source("hu/nooon/dobido/public/images/home/tour_dates/IMG_7487-copy_03.jpg")
    public ImageResource home_tour3();
    @Source("hu/nooon/dobido/public/images/home/tour_dates/IMG_7487-copy_04.jpg")
    public ImageResource home_tour4();


    @Source("hu/nooon/dobido/public/images/band/band_bezs/bezs256.jpg")
    public ImageResource band_bezs();
    @Source("hu/nooon/dobido/public/images/band/band_bezs/balagebkg3.jpg")
    public ImageResource band_bezs_alt();

    @Source("hu/nooon/dobido/public/images/band/band_ervin/ervin256.jpg")
    public ImageResource band_ervin();
    @Source("hu/nooon/dobido/public/images/band/band_ervin/ervinBkg2.jpg")
    public ImageResource band_ervin_alt();

    @Source("hu/nooon/dobido/public/images/band/band_racka/racka256.jpg")
    public ImageResource band_racka();
    @Source("hu/nooon/dobido/public/images/band/band_racka/rackaBkg2.jpg")
    public ImageResource band_racka_alt();

    @Source("hu/nooon/dobido/public/images/band/band_zadi/zadi256.jpg")
    public ImageResource band_zadi();
    @Source("hu/nooon/dobido/public/images/band/band_zadi/zadiBkg2.jpg")
    public ImageResource band_zadi_alt();


    @Source("hu/nooon/dobido/public/images/gallery/landscape/tbalint1.jpg")
    public ImageResource gallery_land_tbalint1();
    @Source("hu/nooon/dobido/public/images/gallery/landscape/tbalint2.jpg")
    public ImageResource gallery_land_tbalint2();
    @Source("hu/nooon/dobido/public/images/gallery/landscape/tbalint3.jpg")
    public ImageResource gallery_land_tbalint3();
    @Source("hu/nooon/dobido/public/images/gallery/landscape/tbalint4.jpg")
    public ImageResource gallery_land_tbalint4();
    @Source("hu/nooon/dobido/public/images/gallery/landscape/tbalint5.jpg")
    public ImageResource gallery_land_tbalint5();
    @Source("hu/nooon/dobido/public/images/gallery/landscape/tbalint6.jpg")
    public ImageResource gallery_land_tbalint6();

    @Source("hu/nooon/dobido/public/images/gallery/landscape/thumb/tbalint1.jpg")
    public ImageResource gallery_land_tbalint1_t();
    @Source("hu/nooon/dobido/public/images/gallery/landscape/thumb/tbalint2.jpg")
    public ImageResource gallery_land_tbalint2_t();
    @Source("hu/nooon/dobido/public/images/gallery/landscape/thumb/tbalint3.jpg")
    public ImageResource gallery_land_tbalint3_t();
    @Source("hu/nooon/dobido/public/images/gallery/landscape/thumb/tbalint4.jpg")
    public ImageResource gallery_land_tbalint4_t();
    @Source("hu/nooon/dobido/public/images/gallery/landscape/thumb/tbalint5.jpg")
    public ImageResource gallery_land_tbalint5_t();
    @Source("hu/nooon/dobido/public/images/gallery/landscape/thumb/tbalint6.jpg")
    public ImageResource gallery_land_tbalint6_t();

    @Source("hu/nooon/dobido/public/images/gallery/portrait/tbalint7.jpg")
    public ImageResource gallery_port_tbalint7();
    @Source("hu/nooon/dobido/public/images/gallery/portrait/tbalint9.jpg")
    public ImageResource gallery_port_tbalint9();
    @Source("hu/nooon/dobido/public/images/gallery/portrait/tbalint10.jpg")
    public ImageResource gallery_port_tbalint10();
    @Source("hu/nooon/dobido/public/images/gallery/portrait/tbalint11.jpg")
    public ImageResource gallery_port_tbalint11();
    @Source("hu/nooon/dobido/public/images/gallery/portrait/tbalint12.jpg")
    public ImageResource gallery_port_tbalint12();
    @Source("hu/nooon/dobido/public/images/gallery/portrait/tbalint13.jpg")
    public ImageResource gallery_port_tbalint13();
    @Source("hu/nooon/dobido/public/images/gallery/portrait/tbalint14.jpg")
    public ImageResource gallery_port_tbalint14();
    @Source("hu/nooon/dobido/public/images/gallery/portrait/tbalint15.jpg")
    public ImageResource gallery_port_tbalint15();
    @Source("hu/nooon/dobido/public/images/gallery/portrait/tbalint16.jpg")
    public ImageResource gallery_port_tbalint16();
    @Source("hu/nooon/dobido/public/images/gallery/portrait/tbalint17.jpg")
    public ImageResource gallery_port_tbalint17();
    @Source("hu/nooon/dobido/public/images/gallery/portrait/tbalint18.jpg")
    public ImageResource gallery_port_tbalint18();
    @Source("hu/nooon/dobido/public/images/gallery/portrait/tbalint19.jpg")
    public ImageResource gallery_port_tbalint19();
    @Source("hu/nooon/dobido/public/images/gallery/portrait/tbalint20.jpg")
    public ImageResource gallery_port_tbalint20();
    @Source("hu/nooon/dobido/public/images/gallery/portrait/tbalint21.jpg")
    public ImageResource gallery_port_tbalint21();
    @Source("hu/nooon/dobido/public/images/gallery/portrait/tbalint22.jpg")
    public ImageResource gallery_port_tbalint22();

    @Source("hu/nooon/dobido/public/images/gallery/portrait/thumb/tbalint7.jpg")
    public ImageResource gallery_port_tbalint7_t();
    @Source("hu/nooon/dobido/public/images/gallery/portrait/thumb/tbalint9.jpg")
    public ImageResource gallery_port_tbalint9_t();
    @Source("hu/nooon/dobido/public/images/gallery/portrait/thumb/tbalint10.jpg")
    public ImageResource gallery_port_tbalint10_t();
    @Source("hu/nooon/dobido/public/images/gallery/portrait/thumb/tbalint11.jpg")
    public ImageResource gallery_port_tbalint11_t();
    @Source("hu/nooon/dobido/public/images/gallery/portrait/thumb/tbalint12.jpg")
    public ImageResource gallery_port_tbalint12_t();
    @Source("hu/nooon/dobido/public/images/gallery/portrait/thumb/tbalint13.jpg")
    public ImageResource gallery_port_tbalint13_t();
    @Source("hu/nooon/dobido/public/images/gallery/portrait/thumb/tbalint14.jpg")
    public ImageResource gallery_port_tbalint14_t();
    @Source("hu/nooon/dobido/public/images/gallery/portrait/thumb/tbalint15.jpg")
    public ImageResource gallery_port_tbalint15_t();
    @Source("hu/nooon/dobido/public/images/gallery/portrait/thumb/tbalint16.jpg")
    public ImageResource gallery_port_tbalint16_t();
    @Source("hu/nooon/dobido/public/images/gallery/portrait/thumb/tbalint17.jpg")
    public ImageResource gallery_port_tbalint17_t();
    @Source("hu/nooon/dobido/public/images/gallery/portrait/thumb/tbalint18.jpg")
    public ImageResource gallery_port_tbalint18_t();
    @Source("hu/nooon/dobido/public/images/gallery/portrait/thumb/tbalint19.jpg")
    public ImageResource gallery_port_tbalint19_t();
    @Source("hu/nooon/dobido/public/images/gallery/portrait/thumb/tbalint20.jpg")
    public ImageResource gallery_port_tbalint20_t();
    @Source("hu/nooon/dobido/public/images/gallery/portrait/thumb/tbalint21.jpg")
    public ImageResource gallery_port_tbalint21_t();
    @Source("hu/nooon/dobido/public/images/gallery/portrait/thumb/tbalint22.jpg")
    public ImageResource gallery_port_tbalint22_t();



    @Source("hu/nooon/dobido/public/images/music/IMG_7575-copy_01.jpg")
    public ImageResource music1();
    @Source("hu/nooon/dobido/public/images/music/IMG_7575-copy_02.jpg")
    public ImageResource music2();
    @Source("hu/nooon/dobido/public/images/music/IMG_7575-copy_03.jpg")
    public ImageResource music3();
    @Source("hu/nooon/dobido/public/images/music/IMG_7575-copy_04.jpg")
    public ImageResource music4();
    @Source("hu/nooon/dobido/public/images/music/IMG_7575-copy_05.jpg")
    public ImageResource music5();
    @Source("hu/nooon/dobido/public/images/music/IMG_7575-copy_06.jpg")
    public ImageResource music6();
    @Source("hu/nooon/dobido/public/images/music/IMG_7575-copy_07.jpg")
    public ImageResource music7();
    @Source("hu/nooon/dobido/public/images/music/IMG_7575-copy_08.jpg")
    public ImageResource music8();
    @Source("hu/nooon/dobido/public/images/music/IMG_7575-copy_09.jpg")
    public ImageResource music9();
    @Source("hu/nooon/dobido/public/images/music/IMG_7575-copy_10.jpg")
    public ImageResource music10();
    @Source("hu/nooon/dobido/public/images/music/IMG_7575-copy_11.jpg")
    public ImageResource music11();
    @Source("hu/nooon/dobido/public/images/music/IMG_7575-copy_12.jpg")
    public ImageResource music12();
    @Source("hu/nooon/dobido/public/images/music/IMG_7575-copy_13.jpg")
    public ImageResource music13();
    @Source("hu/nooon/dobido/public/images/music/IMG_7575-copy_14.jpg")
    public ImageResource music14();
    @Source("hu/nooon/dobido/public/images/music/IMG_7575-copy_15.jpg")
    public ImageResource music15();
    @Source("hu/nooon/dobido/public/images/music/IMG_7575-copy_16.jpg")
    public ImageResource music16();


    @Source("hu/nooon/dobido/public/images/partners/IMG_7322-copy_01.jpg")
    public ImageResource partners1();
    @Source("hu/nooon/dobido/public/images/partners/IMG_7322-copy_02.jpg")
    public ImageResource partners2();
    @Source("hu/nooon/dobido/public/images/partners/IMG_7322-copy_03.jpg")
    public ImageResource partners3();
    @Source("hu/nooon/dobido/public/images/partners/IMG_7322-copy_04.jpg")
    public ImageResource partners4();
    @Source("hu/nooon/dobido/public/images/partners/IMG_7322-copy_05.jpg")
    public ImageResource partners5();
    @Source("hu/nooon/dobido/public/images/partners/IMG_7322-copy_06.jpg")
    public ImageResource partners6();
    @Source("hu/nooon/dobido/public/images/partners/IMG_7322-copy_07.jpg")
    public ImageResource partners7();
    @Source("hu/nooon/dobido/public/images/partners/IMG_7322-copy_08.jpg")
    public ImageResource partners8();
    @Source("hu/nooon/dobido/public/images/partners/IMG_7322-copy_09.jpg")
    public ImageResource partners9();
    @Source("hu/nooon/dobido/public/images/partners/IMG_7322-copy_10.jpg")
    public ImageResource partners10();
    @Source("hu/nooon/dobido/public/images/partners/IMG_7322-copy_11.jpg")
    public ImageResource partners11();
    @Source("hu/nooon/dobido/public/images/partners/IMG_7322-copy_12.jpg")
    public ImageResource partners12();
    @Source("hu/nooon/dobido/public/images/partners/IMG_7322-copy_13.jpg")
    public ImageResource partners13();
    @Source("hu/nooon/dobido/public/images/partners/IMG_7322-copy_14.jpg")
    public ImageResource partners14();
    @Source("hu/nooon/dobido/public/images/partners/IMG_7322-copy_15.jpg")
    public ImageResource partners15();
    @Source("hu/nooon/dobido/public/images/partners/IMG_7322-copy_16.jpg")
    public ImageResource partners16();


    @Source("hu/nooon/dobido/public/images/tour_dates/IMG_7487-copy_01.jpg")
    public ImageResource tour1();
    @Source("hu/nooon/dobido/public/images/tour_dates/IMG_7487-copy_02.jpg")
    public ImageResource tour2();
    @Source("hu/nooon/dobido/public/images/tour_dates/IMG_7487-copy_03.jpg")
    public ImageResource tour3();
    @Source("hu/nooon/dobido/public/images/tour_dates/IMG_7487-copy_04.jpg")
    public ImageResource tour4();
    @Source("hu/nooon/dobido/public/images/tour_dates/IMG_7487-copy_05.jpg")
    public ImageResource tour5();
    @Source("hu/nooon/dobido/public/images/tour_dates/IMG_7487-copy_06.jpg")
    public ImageResource tour6();
    @Source("hu/nooon/dobido/public/images/tour_dates/IMG_7487-copy_07.jpg")
    public ImageResource tour7();
    @Source("hu/nooon/dobido/public/images/tour_dates/IMG_7487-copy_08.jpg")
    public ImageResource tour8();
    @Source("hu/nooon/dobido/public/images/tour_dates/IMG_7487-copy_09.jpg")
    public ImageResource tour9();
    @Source("hu/nooon/dobido/public/images/tour_dates/IMG_7487-copy_10.jpg")
    public ImageResource tour10();
    @Source("hu/nooon/dobido/public/images/tour_dates/IMG_7487-copy_11.jpg")
    public ImageResource tour11();
    @Source("hu/nooon/dobido/public/images/tour_dates/IMG_7487-copy_12.jpg")
    public ImageResource tour12();
    @Source("hu/nooon/dobido/public/images/tour_dates/IMG_7487-copy_13.jpg")
    public ImageResource tour13();
    @Source("hu/nooon/dobido/public/images/tour_dates/IMG_7487-copy_14.jpg")
    public ImageResource tour14();
    @Source("hu/nooon/dobido/public/images/tour_dates/IMG_7487-copy_15.jpg")
    public ImageResource tour15();
    @Source("hu/nooon/dobido/public/images/tour_dates/IMG_7487-copy_16.jpg")
    public ImageResource tour16();


    @Source("hu/nooon/dobido/public/images/whats_new/IMG_7474-copy_01.jpg")
    public ImageResource news1();
    @Source("hu/nooon/dobido/public/images/whats_new/IMG_7474-copy_02.jpg")
    public ImageResource news2();
    @Source("hu/nooon/dobido/public/images/whats_new/IMG_7474-copy_03.jpg")
    public ImageResource news3();
    @Source("hu/nooon/dobido/public/images/whats_new/IMG_7474-copy_04.jpg")
    public ImageResource news4();
    @Source("hu/nooon/dobido/public/images/whats_new/IMG_7474-copy_05.jpg")
    public ImageResource news5();
    @Source("hu/nooon/dobido/public/images/whats_new/IMG_7474-copy_06.jpg")
    public ImageResource news6();
    @Source("hu/nooon/dobido/public/images/whats_new/IMG_7474-copy_07.jpg")
    public ImageResource news7();
    @Source("hu/nooon/dobido/public/images/whats_new/IMG_7474-copy_08.jpg")
    public ImageResource news8();
    @Source("hu/nooon/dobido/public/images/whats_new/IMG_7474-copy_09.jpg")
    public ImageResource news9();
    @Source("hu/nooon/dobido/public/images/whats_new/IMG_7474-copy_10.jpg")
    public ImageResource news10();
    @Source("hu/nooon/dobido/public/images/whats_new/IMG_7474-copy_11.jpg")
    public ImageResource news11();
    @Source("hu/nooon/dobido/public/images/whats_new/IMG_7474-copy_12.jpg")
    public ImageResource news12();
    @Source("hu/nooon/dobido/public/images/whats_new/IMG_7474-copy_13.jpg")
    public ImageResource news13();
    @Source("hu/nooon/dobido/public/images/whats_new/IMG_7474-copy_14.jpg")
    public ImageResource news14();
    @Source("hu/nooon/dobido/public/images/whats_new/IMG_7474-copy_15.jpg")
    public ImageResource news15();
    @Source("hu/nooon/dobido/public/images/whats_new/IMG_7474-copy_16.jpg")
    public ImageResource news16();

    @Source("hu/nooon/dobido/public/images/icons/headphones.jpg") // 262x380
    public ImageResource headphones();


    @Source("hu/nooon/dobido/public/music/fjb_track.mp3")
    public DataResource audio1();



    @Source("hu/nooon/dobido/public/texts/balageBio.txt")
    public TextResource balageBio();
    @Source("hu/nooon/dobido/public/texts/ervinBio.txt")
    public TextResource ervinBio();
    @Source("hu/nooon/dobido/public/texts/rackaBio.txt")
    public TextResource rackaBio();
    @Source("hu/nooon/dobido/public/texts/zadiBio.txt")
    public TextResource zadiBio();


}
